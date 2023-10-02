package tech.leondev.wakimob.sale.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaleSimulator {
    private String customerName;
    private String realtorName;
    private String plotTitle;
    private LocalDateTime dateSimulate;
    private BigDecimal plotPrice;
    private String paymentCondition;
    private Integer numberInstallments;
    private BigDecimal amountInstallments;

    public SaleSimulator(Plot plot, Realtor realtor, Customer customer, PaymentCondition paymentCondition){
        this.customerName = customer.getName();
        this.realtorName = realtor.getName();
        this.plotTitle = plot.getTitle();
        this.dateSimulate = LocalDateTime.now();
        this.plotPrice = plot.getPrice();
        this.paymentCondition = paymentCondition.getDescription();
        this.numberInstallments = paymentCondition.getNumberOfInstallments();
        this.amountInstallments = Sale.calculateAmountInstallments(paymentCondition, plot.getPrice());
    }
}
