package tech.leondev.wakimob.properties.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    protected PropertyStatus statusProperty;
    @NotNull
    @Column(columnDefinition = "decimal(7,2)")
    protected BigDecimal price;
    @Column(name = "total_area")
    protected double totalArea;
}
