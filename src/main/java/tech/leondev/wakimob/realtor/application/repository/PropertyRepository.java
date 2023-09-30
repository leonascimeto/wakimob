package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.properties.domain.Plot;

public interface PropertyRepository {
    Plot savePlot(Plot plot);
}
