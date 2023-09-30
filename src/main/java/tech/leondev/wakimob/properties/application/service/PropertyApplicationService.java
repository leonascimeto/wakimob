package tech.leondev.wakimob.properties.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.application.repository.PropertyRepository;

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
}
