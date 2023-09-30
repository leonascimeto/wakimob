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
}
