package tech.leondev.wakimob.properties.application.service;

import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PropertyService {
    PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO);

    List<PlotResponseDTO> listPlots();

    PlotResponseDTO getPLotById(UUID idPlot);

    void updatePlot(PlotRequestDTO plotRequestDTO, UUID idPlot);

    void deletePlot(UUID idPlot);
}
