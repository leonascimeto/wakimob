package tech.leondev.wakimob.properties.application.api;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.leondev.wakimob.properties.domain.PropertyStatus;

import java.math.BigDecimal;

public record ApartmentRequestDTO(
        @NotBlank
        @Size(min = 4, max = 40)
        String title,
        @Size(min = 4, max = 300)
        String description,
        @Column(name = "status")
        @Enumerated(EnumType.STRING)
        PropertyStatus statusProperty,
        @NotNull
        @Column(columnDefinition = "decimal(7,2)")
        BigDecimal price,
        double totalArea,
        Integer bedrooms,
        Integer bathrooms,
        Integer garageSpaces
) {
}
