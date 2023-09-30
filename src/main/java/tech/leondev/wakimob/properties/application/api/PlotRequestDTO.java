package tech.leondev.wakimob.properties.application.api;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.leondev.wakimob.properties.domain.PlotSoilType;
import tech.leondev.wakimob.properties.domain.PlotTopography;
import tech.leondev.wakimob.properties.domain.PropertyStatus;

import java.math.BigDecimal;

public record PlotRequestDTO(
        @NotBlank
        @Size(min = 4, max = 40)
        String title,
        @Size(min = 4, max = 300)
        String description,
        @Enumerated(EnumType.STRING)
        PropertyStatus statusProperty,
        @NotNull
        @Column(columnDefinition = "decimal(10,2)")
        BigDecimal price,
        double totalArea,
        @Enumerated(EnumType.STRING)
        PlotTopography plotTopography,
        @Enumerated(EnumType.STRING)
        PlotSoilType plotSoilType
) {
}
