package tech.leondev.wakimob.properties.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.properties.application.service.PropertyService;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PropertyController implements PropertyApi {
    private final PropertyService propertyService;
    @Override
    public PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO) {
        log.info("[start] PropertyController - savePlot");
        PlotResponseDTO response = propertyService.savePlot(plotRequestDTO);
        log.info("[start] PropertyController - savePlot");
        return response;
    }

    @Override
    public List<PlotResponseDTO> listPlots() {
        log.info("[start] PropertyController - listPlots");
        List<PlotResponseDTO> response = propertyService.listPlots();
        log.info("[end] PropertyController - listPlots");
        return response;
    }
}
