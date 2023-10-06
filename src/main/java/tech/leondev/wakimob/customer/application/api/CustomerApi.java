package tech.leondev.wakimob.customer.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.handler.ErrorApiResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Clientes",  description = "Recursos com operações relativas ao controle de clientes")
@RestController
@RequestMapping("/v1/customers")
public interface CustomerApi {
    @Operation(summary = "Cadastrar cliente", description = "Recurso para cadastrar um novo cliente",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso",
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
    CustomerResponseDTO save(@RequestBody @Valid CustomerRequestDTO customerCreateDTO);

    @Operation(summary = "Listar clientes", description = "Recurso para listar todos os clientes",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Clientes localizados com sucesso ou retorna um vetor vázio",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class)
                            )
                    )
            }
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CustomerResponseDTO> list();

    @Operation(summary = "Buscar cliente", description = "Recurso para localizar cliente pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso localizado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @GetMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    CustomerResponseDTO get(@PathVariable UUID idCustomer);

    @Operation(summary = "Alterar dados do cliente", description = "Recurso para alterar dados do cliente com o ID informado",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados do cliente alterado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @PatchMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody @Valid CustomerRequestDTO customerRequestDTO, @PathVariable UUID idCustomer);
}
