package tech.leondev.wakimob.sale.application.service;

import tech.leondev.wakimob.sale.application.api.SaleRequestDTO;
import tech.leondev.wakimob.sale.application.api.SaleResponseDTO;
import tech.leondev.wakimob.sale.application.api.SimulateSalePlotResponseDto;
import tech.leondev.wakimob.sale.domain.PaymentCondition;

import java.util.UUID;

public interface SaleService {
    SimulateSalePlotResponseDto simulatePlotSale(UUID idPlot, UUID idCustomer, String username, PaymentCondition paymentCondition);

    SaleResponseDTO executeSalePlot(SaleRequestDTO saleRequestDTO, String username);
}
