package tech.leondev.wakimob.properties.application.api;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.properties.domain.PlotSoilType;
import tech.leondev.wakimob.properties.domain.PlotTopography;
import tech.leondev.wakimob.properties.domain.PropertyStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class PlotResponseDTO {
    private UUID idProperty;
    private String title;
    private String description;
    private PropertyStatus statusProperty;
    private BigDecimal price;
    private PlotTopography plotTopography;
    private PlotSoilType plotSoilType;

    public PlotResponseDTO(Plot plot) {
        this.idProperty = plot.getIdProperty();
        this.title = plot.getTitle();
        this.description = plot.getDescription();
        this.statusProperty = plot.getStatusProperty();
        this.price = plot.getPrice();
        this.plotTopography = plot.getPlotTopography();
        this.plotSoilType = plot.getPlotSoilType();
    }

}
