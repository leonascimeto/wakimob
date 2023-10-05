package tech.leondev.wakimob.sale.application.api;

import jakarta.persistence.Access;
import lombok.*;
import tech.leondev.wakimob.sale.domain.Sale;
import tech.leondev.wakimob.sale.domain.SaleApartment;
import tech.leondev.wakimob.sale.domain.SalePlot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SaleResponseDTO {
    private String nameCustomer;
    private String cpfCustomer;
    private String nameRealtor;
    private LocalDateTime dateSale;
    private String titleProperty;
    private String addressProperty;
    private BigDecimal priceProperty;
    private BigDecimal realtorRake;
    private String typePayment;
    private Integer numberInstallments;
    private BigDecimal amountInstallments;

    public SaleResponseDTO(SalePlot salePlot) {
        this.nameCustomer = salePlot.getCustomer().getName();
        this.cpfCustomer = salePlot.getCustomer().getCpf();
        this.nameRealtor = salePlot.getRealtor().getName();
        this.dateSale = salePlot.getSaleDate();
        this.titleProperty = salePlot.getPlot().getTitle();
        this.addressProperty = salePlot.getPlot().getAddress();
        this.priceProperty = salePlot.getPlot().getPrice();
        this.realtorRake = salePlot.getRakeRealtor();
        this.typePayment = salePlot.getPaymentCondition();
        this.numberInstallments = salePlot.getNumberInstallments();
        this.amountInstallments = salePlot.getAmountInstallments();
    }

    public SaleResponseDTO(SaleApartment sale) {
        this.nameCustomer = sale.getCustomer().getName();
        this.cpfCustomer = sale.getCustomer().getCpf();
        this.nameRealtor = sale.getRealtor().getName();
        this.dateSale = sale.getSaleDate();
        this.titleProperty = sale.getApartment().getTitle();
        this.addressProperty = sale.getApartment().getAddress();
        this.priceProperty = sale.getApartment().getPrice();
        this.realtorRake = sale.getRakeRealtor();
        this.typePayment = sale.getPaymentCondition();
        this.numberInstallments = sale.getNumberInstallments();
        this.amountInstallments = sale.getAmountInstallments();
    }
}
