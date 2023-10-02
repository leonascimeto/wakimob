package tech.leondev.wakimob.sale.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tech.leondev.wakimob.properties.domain.Apartment;

@Entity
@DiscriminatorValue("SaleApartment")
public class SaleApartment extends Sale{
    @ManyToOne
    @JoinColumn(name = "id_apartment", nullable = true)
    private Apartment apartment;
}
