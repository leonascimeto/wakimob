package tech.leondev.wakimob.properties.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.properties.application.service.PropertyService;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PropertyController implements PropertyApi {
    private final PropertyService propertyService;
    @Override
    public PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO) {
        log.info("[start] PropertyController - savePlot");
        PlotResponseDTO response = propertyService.savePlot(plotRequestDTO);
        log.info("[end] PropertyController - savePlot");
        return response;
    }
}
