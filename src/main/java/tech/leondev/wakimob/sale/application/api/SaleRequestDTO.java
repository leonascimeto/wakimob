package tech.leondev.wakimob.sale.application.api;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import tech.leondev.wakimob.sale.domain.PaymentCondition;
import tech.leondev.wakimob.sale.domain.Sale;

import java.util.UUID;

public record SaleRequestDTO(
        @NotNull
        UUID idCustomer,
        @NotNull
        UUID idProperty,
        @Enumerated(EnumType.STRING)
        PaymentCondition paymentCondition
) {
}
