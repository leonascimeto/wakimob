package tech.leondev.wakimob.sale.application.api;

import lombok.*;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.domain.Realtor;
import tech.leondev.wakimob.sale.domain.PaymentCondition;
import tech.leondev.wakimob.sale.domain.SaleSimulator;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimulateSalePlotResponseDto {
    private String customer;
    private String realtor;
    private LocalDateTime date;
    private String plot;
    private BigDecimal price;
    private String typePayment;
    private Integer numberInstallments;
    private BigDecimal amountInstallments;

    public SimulateSalePlotResponseDto(SaleSimulator saleSimulator){
        this.customer = saleSimulator.getCustomerName();
        this.realtor = saleSimulator.getRealtorName();
        this.date = saleSimulator.getDateSimulate();
        this.plot = saleSimulator.getPlotTitle();
        this.price = saleSimulator.getPlotPrice();
        this.typePayment = saleSimulator.getPaymentCondition();
        this.numberInstallments = saleSimulator.getNumberInstallments();
        this.amountInstallments = saleSimulator.getAmountInstallments();
    }
}
