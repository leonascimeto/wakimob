package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.properties.domain.Plot;

import java.util.List;

public interface PropertyRepository {
    Plot savePlot(Plot plot);

    List<Plot> listPlots();
}
