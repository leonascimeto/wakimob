package tech.leondev.wakimob.realtor.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.handler.ErrorApiResponse;

import java.util.UUID;

@Tag(name = "Vendedores", description = "Recursos com operações relativas ao controle de vendedores")
@RequestMapping("/v1/realtors")
@RestController
public interface RealtorAPI {
    @Operation(summary = "Cadastrar vendedores", description = "Recurso para cadastrar um novo vendedor",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Vendedor cadastrado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    RealtorResponseDTO save(@RequestBody @Valid RealtorCreateDTO request);

    @Operation(summary = "Buscar vendedor", description = "Recurso para localizar vendedor pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Vendedor localizado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Vendedor não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @GetMapping("/{idRealtor}")
    @ResponseStatus(HttpStatus.OK)
    RealtorResponseDTO get(@PathVariable UUID idRealtor);
}
