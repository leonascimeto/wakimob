package tech.leondev.wakimob.sale.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.properties.domain.Apartment;
import tech.leondev.wakimob.realtor.domain.Realtor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@DiscriminatorValue("SaleApartment")
@Getter
public class SaleApartment extends Sale{
    @ManyToOne
    @JoinColumn(name = "id_apartment", nullable = true)
    private Apartment apartment;

    public SaleApartment(Apartment apartment, Customer customer, Realtor realtor, PaymentCondition paymentCondition) {
        super();
        this.apartment = apartment;
        this.customer = customer;
        this.realtor = realtor;
        this.paymentCondition = paymentCondition.getDescription();
        this.numberInstallments = paymentCondition.getNumberOfInstallments();
        this.amountInstallments = Sale.calculateAmountInstallments(paymentCondition, apartment.getPrice());
        this.rakeRealtor = Sale.calculateRealtorRake(5, apartment.getPrice());
    }
}
