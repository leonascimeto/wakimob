package tech.leondev.wakimob.properties.application.repository;

import tech.leondev.wakimob.properties.domain.Plot;

import java.util.List;
import java.util.UUID;

public interface PlotRepository {
    Plot savePlot(Plot plot);

    List<Plot> listPlots();

    Plot getPlotById(UUID idPlot);

    void deletePlot(Plot plot);
}
