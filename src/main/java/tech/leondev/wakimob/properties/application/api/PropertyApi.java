package tech.leondev.wakimob.properties.application.api;

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

import java.util.List;
import java.util.UUID;

@Tag(name = "Imoveis", description = "Recurso com operação relativas aos imoveis")
@RestController
@RequestMapping("/v1/properties")
public interface PropertyApi {
    @Operation(summary = "Cadastrar terreno", description = "Recurso para cadastrar um novo terreno",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Terreno cadastrado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @PostMapping("/plots")
    @ResponseStatus(HttpStatus.OK)
    PlotResponseDTO savePlot(@RequestBody @Valid PlotRequestDTO plotRequestDTO);

    @Operation(summary = "Listar terrenos", description = "Recurso para listar todos os terrenos",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Terrenos localizados com sucesso ou retorna uma lista vazia",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class)
                            )
                    )
            }
    )
    @GetMapping("/plots")
    @ResponseStatus(HttpStatus.OK)
    List<PlotResponseDTO> listPlots();

    @Operation(summary = "Buscar terreno", description = "Recurso para localizar terreno pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso localizado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Terreno não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @GetMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.OK)
    PlotResponseDTO getPlotById(@PathVariable UUID idPlot);

    @Operation(summary = "Alterar dados do terreno", description = "Recurso para alterar dados do terreno com o ID informado",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados do terreno alterado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Terreno não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @PatchMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePlot(@RequestBody @Valid PlotRequestDTO plotRequestDTO, @PathVariable UUID idPlot);

    @Operation(summary = "Deletar terreno", description = "Recurso para deletar terreno pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Recurso deletado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Terreno não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @DeleteMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlot(@PathVariable UUID idPlot);

    @Operation(summary = "Cadastrar apartamento", description = "Recurso para cadastrar um novo apartamento",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Apartamento cadastrado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
            }
    )
    @PostMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponseDTO saveApartment(@RequestBody @Valid ApartmentRequestDTO apartmentRequestDTO);

    @Operation(summary = "Listar apartamentos", description = "Recurso para listar todos os terrenos",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Apartamentos localizados com sucesso ou retorna uma lista vazia",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class)
                            )
                    )
            }
    )
    @GetMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    List<ApartmentResponseDTO> listApartment();

    @Operation(summary = "Buscar apartamento", description = "Recurso para localizar apartamento pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso localizado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Apartamento não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @GetMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponseDTO getApartmentById(@PathVariable UUID idApartment);

    @Operation(summary = "Alterar dados do apartamento", description = "Recurso para alterar dados do apartamento com o ID informado",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados do apartamento alterado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado devido a entrada de dados inválidos",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Apartamento não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @PatchMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateApartment(@RequestBody @Valid ApartmentRequestDTO apartmentRequestDTO, @PathVariable UUID idApartment);

    @Operation(summary = "Deletar apartamento", description = "Recurso para deletar apartamento pelo ID",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Recurso deletado com sucesso",
                            content = @Content(mediaType = "Application/json",
                                    schema = @Schema(implementation = CustomerResponseDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Apartamento não encontrado",
                            content = @Content(mediaType = "Application/json", schema = @Schema(implementation = ErrorApiResponse.class))
                    )
            }
    )
    @DeleteMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteApartment(@PathVariable UUID idApartment);
}
