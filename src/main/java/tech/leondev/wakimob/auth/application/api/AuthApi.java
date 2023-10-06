package tech.leondev.wakimob.auth.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.handler.ErrorApiResponse;

@Tag(name = "Autenticação", description = "Recurso para proceder com a autenticação na API")
@RestController
@RequestMapping("v1/auth")
public interface AuthApi {
    @Operation(summary = "Autenticar usuário", description = "Recurso para autenticar usuário na API",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso e retirna um bearer token",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = AuthResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "401", description = "Credenciais inválidas",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    AuthResponseDTO login(@RequestBody @Valid AuthLoginDTO authLoginDTO);
}
