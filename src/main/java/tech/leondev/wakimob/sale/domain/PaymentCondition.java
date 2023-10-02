package tech.leondev.wakimob.sale.domain;

import lombok.Getter;

@Getter
public enum PaymentCondition {
    CASH("Cash", 1),
    INSTALLMENTS_180("Installments", 180);

    private final String description;
    private final int numberOfInstallments;

    PaymentCondition(String description, int numberOfInstallments) {
        this.description = description;
        this.numberOfInstallments = numberOfInstallments;
    }
}
