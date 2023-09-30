package tech.leondev.wakimob.properties.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/properties")
public interface PropertyApi {
    @PostMapping("/plots")
    @ResponseStatus(HttpStatus.OK)
    PlotResponseDTO savePlot(@RequestBody @Valid PlotRequestDTO plotRequestDTO);
}
