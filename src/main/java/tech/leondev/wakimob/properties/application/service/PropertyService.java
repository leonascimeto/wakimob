package tech.leondev.wakimob.properties.application.service;

import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;

public interface PropertyService {
    PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO);
}
