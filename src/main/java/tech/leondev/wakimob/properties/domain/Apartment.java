package tech.leondev.wakimob.properties.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "apartments")
@Entity(name = "apartments")
public class Apartment extends Property{
    private Integer bedrooms;
    private Integer bathrooms;
    @Column(name = "garage_space")
    private Integer garageSpaces;

    public Apartment(ApartmentRequestDTO apartmentRequestDTO){
        super();
        this.title = apartmentRequestDTO.title();
        this.description = apartmentRequestDTO.description();
        this.totalArea = apartmentRequestDTO.totalArea();
        this.price = apartmentRequestDTO.price();
        this.statusProperty = apartmentRequestDTO.statusProperty();
        this.bedrooms = apartmentRequestDTO.bedrooms();
        this.bathrooms = apartmentRequestDTO.bathrooms();
        this.garageSpaces = apartmentRequestDTO.garageSpaces();
    }
}
