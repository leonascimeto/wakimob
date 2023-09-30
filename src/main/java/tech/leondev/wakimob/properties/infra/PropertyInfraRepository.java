package tech.leondev.wakimob.properties.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.handler.ApiException;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.application.repository.PropertyRepository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Plot getPlotById(UUID idPlot) {
        log.info("[start] PropertyInfraRepository - getPlotById");
        Plot plot = plotSpringDataJPARepository.findById(idPlot)
                        .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Plot not found"));
        log.info("[end] PropertyInfraRepository - getPlotById");
        return plot;
    }

    @Override
    public void deletePlot(Plot plot) {
        log.info("[start] PropertyInfraRepository - deletePlot");
        plotSpringDataJPARepository.delete(plot);
        log.info("[end] PropertyInfraRepository - deletePlot");
    }
}
