package tech.leondev.wakimob.sale.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.domain.Realtor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@DiscriminatorValue("SalePlot")
@Getter
@Entity
public class SalePlot extends Sale{
    @ManyToOne
    @JoinColumn(name = "id_plot", nullable = true)
    private Plot plot;

    public SalePlot(Plot plot, Customer customer, Realtor realtor, PaymentCondition paymentCondition) {
        super();
        this.plot = plot;
        this.customer = customer;
        this.realtor = realtor;
        this.paymentCondition = paymentCondition.getDescription();
        this.numberInstallments = paymentCondition.getNumberOfInstallments();
        this.amountInstallments = Sale.calculateAmountInstallments(paymentCondition, plot.getPrice());
        this.rakeRealtor = Sale.calculateRealtorRake(5, plot.getPrice());
    }
}
