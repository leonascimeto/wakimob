package tech.leondev.wakimob.properties.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.properties.application.service.PropertyService;

import java.util.List;
import java.util.UUID;

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

    @Override
    public PlotResponseDTO getPlotById(UUID idPlot) {
        log.info("[start] PropertyController - getPlotById");
        PlotResponseDTO response = propertyService.getPLotById(idPlot);
        log.info("[end] PropertyController - getPlotById");
        return response;
    }

    @Override
    public void updatePlot(PlotRequestDTO plotRequestDTO, UUID idPlot) {
        log.info("[start] PropertyController - updatePlot");
        propertyService.updatePlot(plotRequestDTO, idPlot);
        log.info("[end] PropertyController - updatePlot");
    }

    @Override
    public void deletePlot(UUID idPlot) {
        log.info("[start] PropertyController - deletePlot");
        propertyService.deletePlot(idPlot);
        log.info("[end] PropertyController - deletePlot");
    }
}
