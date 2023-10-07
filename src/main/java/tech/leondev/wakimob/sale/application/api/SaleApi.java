package tech.leondev.wakimob.sale.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.handler.ErrorApiResponse;
import tech.leondev.wakimob.sale.domain.PaymentCondition;

import java.util.UUID;

@Tag(name = "Vendas", description = "Recurso com operação relativas a simulação e registor de vendas")
@RestController
@RequestMapping("v1/sales")
public interface SaleApi {
    @Operation(summary = "Gerar simulação de venda do terreno", description = "Recurso para geração de simulação de venda",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Simulação relizada com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente ou terreno não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @GetMapping("/plots/{idPlot}/customers/{idCustomer}/payment-conditions/{paymentCondition}/simulator")
    SimulateSaleResponseDTO simulatePlotSale(@RequestHeader(name = "Authorization",required = true) String token, @PathVariable UUID idPlot, @PathVariable UUID idCustomer,
                                             @PathVariable PaymentCondition paymentCondition);

    @Operation(summary = "Cadastrar ordem de venda do terreno", description = "Recurso para registrar ordem de venda de um terrreno",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Ordem registrada com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = SaleResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Recurso não processado devido ao imóvel esta indisponivel para venda",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @PostMapping("/plots")
    SaleResponseDTO executeSalePlot(@RequestHeader(name = "Authorization",required = true) String token,
                                   @RequestBody @Valid SaleRequestDTO saleRequestDTO);

    @Operation(summary = "Gerar simulação de venda do apartamento", description = "Recurso para geração de simulação de venda",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Simulação relizada com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente ou apartamento não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @GetMapping("/apartments/{idApartment}/customers/{idCustomer}/payment-conditions/{paymentCondition}/simulator")
    SimulateSaleResponseDTO simulateApartmentSale(@RequestHeader(name = "Authorization",required = true) String token,
                                                           @PathVariable UUID idApartment, @PathVariable UUID idCustomer,
                                                           @PathVariable PaymentCondition paymentCondition);

    @Operation(summary = "Cadastrar ordem de venda do apartamento", description = "Recurso para registrar ordem de venda de um apartamento",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Ordem registrada com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = SaleResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Recurso não processado devido ao imóvel esta indisponivel para venda",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @PostMapping("/apartments")
    SaleResponseDTO executeApartment(@RequestHeader(name = "Authorization", required = true) String token,
                                     @RequestBody @Valid SaleRequestDTO saleRequestDTO);
}
