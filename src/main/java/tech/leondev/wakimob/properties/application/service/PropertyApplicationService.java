package tech.leondev.wakimob.properties.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.application.repository.PropertyRepository;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class PropertyApplicationService implements PropertyService{
    private final PropertyRepository propertyRepository;
    @Override
    public PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO) {
        log.info("[start] PropertyApplicationService - savePlot");
        Plot plot = propertyRepository.savePlot(new Plot(plotRequestDTO));
        log.info("[end] PropertyApplicationService - savePlot");
        return new PlotResponseDTO(plot);
    }

    @Override
    public List<PlotResponseDTO> listPlots() {
        log.info("[start] PropertyApplicationService - listPlots");
        List<Plot> plots = propertyRepository.listPlots();
        log.info("[end] PropertyApplicationService - listPlots");
        return PlotResponseDTO.convertPlotsToList(plots);
    }

    @Override
    public PlotResponseDTO getPLotById(UUID idPlot) {
        log.info("[start] PropertyApplicationService - getPLotById");
        Plot plot = propertyRepository.getPlotById(idPlot);
        log.info("[end] PropertyApplicationService - getPLotById");
        return new PlotResponseDTO(plot);
    }

    @Override
    public void updatePlot(PlotRequestDTO plotRequestDTO, UUID idPlot) {
        log.info("[start] PropertyApplicationService - updatePlot");
        Plot plot = propertyRepository.getPlotById(idPlot);
        plot.update(plotRequestDTO);
        propertyRepository.savePlot(plot);
        log.info("[end] PropertyApplicationService - updatePlot");
    }

    @Override
    public void deletePlot(UUID idPlot) {
        log.info("[start] PropertyApplicationService - deletePlot");
        Plot plot = propertyRepository.getPlotById(idPlot);
        propertyRepository.deletePlot(plot);
        log.info("[end] PropertyApplicationService - deletePlot");
    }
}
