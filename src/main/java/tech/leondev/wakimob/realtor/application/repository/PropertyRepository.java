package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.properties.domain.Plot;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository {
    Plot savePlot(Plot plot);

    List<Plot> listPlots();

    Plot getPlotById(UUID idPlot);

    void deletePlot(Plot plot);
}
