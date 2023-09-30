package tech.leondev.wakimob.properties.domain;

import jakarta.persistence.*;
import lombok.*;
import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "plots")
@Entity(name = "plots")
public class Plot extends Property{
    @Column(name = "topography")
    @Enumerated(EnumType.STRING)
    private PlotTopography plotTopography;
    @Column(name = "soil_type")
    @Enumerated(EnumType.STRING)
    private PlotSoilType plotSoilType;

    public Plot(PlotRequestDTO plotRequestDTO){
        super();
        this.title = plotRequestDTO.title();
        this.description = plotRequestDTO.description();
        this.totalArea = plotRequestDTO.totalArea();
        this.price = plotRequestDTO.price();
        this.statusProperty = plotRequestDTO.statusProperty();
        this.plotTopography = plotRequestDTO.plotTopography();
        this.plotSoilType = plotRequestDTO.plotSoilType();
    }
}
