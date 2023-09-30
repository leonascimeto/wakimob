package tech.leondev.wakimob.properties.application.service;

import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;

import java.util.List;

public interface PropertyService {
    PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO);

    List<PlotResponseDTO> listPlots();
}
