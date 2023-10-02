package tech.leondev.wakimob.properties.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.http.HttpStatus;
import tech.leondev.wakimob.handler.ApiException;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Table(name = "properties")
@Entity(name = "properties")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    protected UUID idProperty;
    @NotBlank
    @Size(min = 4, max = 40)
    protected String title;
    @Size(min = 4, max = 300)
    protected String description;
    @NotBlank
    @Size(min = 4, max = 80)
    protected String address;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    protected PropertyStatus statusProperty = PropertyStatus.AVAILABLE;
    @NotNull
    @Column(columnDefinition = "decimal(7,2)")
    protected BigDecimal price;
    @Column(name = "total_area")
    protected double totalArea;

    public void validPropertyAvailable(){
        if(!this.statusProperty.equals(PropertyStatus.AVAILABLE)){
            throw ApiException.build(HttpStatus.BAD_REQUEST, "Property is not available for sale.");
        }
    }

    public void soldProperty(){
        this.statusProperty = PropertyStatus.SOLD;
    }
}
