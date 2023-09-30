package tech.leondev.wakimob.properties.application.api;

import jakarta.persistence.Column;
import lombok.Value;
import tech.leondev.wakimob.properties.domain.Apartment;
import tech.leondev.wakimob.properties.domain.PropertyStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ApartmentResponseDTO {
    private UUID idProperty;
    private String title;
    private String description;
    private PropertyStatus statusProperty;
    private BigDecimal price;
    private double totalArea;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer garageSpaces;

    public ApartmentResponseDTO(Apartment apartment) {
        this.idProperty = apartment.getIdProperty();
        this.title = apartment.getTitle();
        this.description = apartment.getDescription();
        this.statusProperty = apartment.getStatusProperty();
        this.price = apartment.getPrice();
        this.totalArea = apartment.getTotalArea();
        this.bedrooms = apartment.getBedrooms();
        this.bathrooms = apartment.getBathrooms();
        this.garageSpaces = apartment.getGarageSpaces();
    }

    public static List<ApartmentResponseDTO> convertApartmentsToList(List<Apartment> apartaments) {
        return apartaments.stream().map(ApartmentResponseDTO::new).collect(Collectors.toList());
    }
}
