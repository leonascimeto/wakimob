package tech.leondev.wakimob.properties.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.application.repository.PropertyRepository;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Repository
public class PropertyInfraRepository implements PropertyRepository {
    private final PlotSpringDataJPARepository plotSpringDataJPARepository;
    @Override
    public Plot savePlot(Plot plot) {
        log.info("[start] PropertyInfraRepository - savePlot");
        Plot plotSaved = plotSpringDataJPARepository.save(plot);
        log.info("[end] PropertyInfraRepository - savePlot");
        return plotSaved;
    }

    @Override
    public List<Plot> listPlots() {
        log.info("[start] PropertyInfraRepository - listPlots");
        List<Plot> plots = plotSpringDataJPARepository.findAll();
        log.info("[end] PropertyInfraRepository - listPlots");
        return plots;
    }
}
