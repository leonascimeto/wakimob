package tech.leondev.wakimob.properties.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/properties")
public interface PropertyApi {
    @PostMapping("/plots")
    @ResponseStatus(HttpStatus.OK)
    PlotResponseDTO savePlot(@RequestBody @Valid PlotRequestDTO plotRequestDTO);

    @GetMapping("/plots")
    @ResponseStatus(HttpStatus.OK)
    List<PlotResponseDTO> listPlots();

    @GetMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.OK)
    PlotResponseDTO getPlotById(@PathVariable UUID idPlot);

    @PatchMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePlot(@RequestBody @Valid PlotRequestDTO plotRequestDTO, @PathVariable UUID idPlot);

    @DeleteMapping("/plots/{idPlot}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlot(@PathVariable UUID idPlot);

    @PostMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponseDTO saveApartment(@RequestBody @Valid ApartmentRequestDTO apartmentRequestDTO);

    @GetMapping("/apartments")
    @ResponseStatus(HttpStatus.OK)
    List<ApartmentResponseDTO> listApartment();

    @GetMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponseDTO getApartmentById(@PathVariable UUID idApartment);

    @PatchMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateApartment(@RequestBody @Valid ApartmentRequestDTO apartmentRequestDTO, @PathVariable UUID idApartment);

    @DeleteMapping("/apartments/{idApartment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteApartment(@PathVariable UUID idApartment);
}
