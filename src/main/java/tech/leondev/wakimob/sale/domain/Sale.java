package tech.leondev.wakimob.sale.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.handler.ApiException;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table(name = "sales")
@Entity(name = "sales")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    protected UUID idSale;
    @NotBlank
    @Column(name = "payment_condition")
    protected String paymentCondition;
    @Column(name = "number_installments")
    protected int numberInstallments;
    @Column(name = "amount_installments")
    protected BigDecimal amountInstallments;
    @Column(name = "rake_realtor")
    protected BigDecimal rakeRealtor;
    @NotNull
    @Builder.Default
    protected LocalDateTime saleDate = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    protected Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_realtor", nullable = false)
    protected Realtor realtor;

    public static BigDecimal calculateAmountInstallments(PaymentCondition paymentCondition, BigDecimal price){
        return price.divide(BigDecimal.valueOf(paymentCondition.getNumberOfInstallments()), RoundingMode.CEILING);
    }

    public static BigDecimal calculateRealtorRake(Integer realtorRakePercentage, BigDecimal price){
        if (realtorRakePercentage == null || price == null) {
            throw ApiException.build(HttpStatus.UNPROCESSABLE_ENTITY, "realtorRakePercentage and price must not be null");
        }
        if (realtorRakePercentage < 0 || realtorRakePercentage > 100) {
            throw ApiException.build(HttpStatus.UNPROCESSABLE_ENTITY, "realtorRakePercentage must be between 0 and 100");
        }
        BigDecimal percentageFactor = BigDecimal.valueOf(realtorRakePercentage).divide(BigDecimal.valueOf(100));
        return price.multiply(percentageFactor);
    }
}
