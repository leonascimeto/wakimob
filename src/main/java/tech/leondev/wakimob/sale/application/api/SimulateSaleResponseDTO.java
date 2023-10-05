package tech.leondev.wakimob.sale.application.api;

import lombok.*;
import tech.leondev.wakimob.sale.domain.SaleSimulator;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimulateSaleResponseDTO {
    private String customer;
    private String realtor;
    private LocalDateTime date;
    private String property;
    private BigDecimal price;
    private String typePayment;
    private Integer numberInstallments;
    private BigDecimal amountInstallments;

    public SimulateSaleResponseDTO(SaleSimulator saleSimulator){
        this.customer = saleSimulator.getCustomerName();
        this.realtor = saleSimulator.getRealtorName();
        this.date = saleSimulator.getDateSimulate();
        this.property = saleSimulator.getPropertyTitle();
        this.price = saleSimulator.getPrice();
        this.typePayment = saleSimulator.getPaymentCondition();
        this.numberInstallments = saleSimulator.getNumberInstallments();
        this.amountInstallments = saleSimulator.getAmountInstallments();
    }
}
