package tech.leondev.wakimob.sale.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.auth.application.service.TokenService;
import tech.leondev.wakimob.sale.application.service.SaleService;
import tech.leondev.wakimob.sale.domain.PaymentCondition;

import java.util.UUID;


@Log4j2
@RequiredArgsConstructor
@RestController
public class SaleController implements SaleApi{
    private final SaleService saleService;
    private final TokenService tokenService;

    @Override
    public SimulateSalePlotResponseDto simulatePlotSale(String token, UUID idPlot, UUID idCustomer, PaymentCondition paymentCondition) {
        log.info("[start] SaleController - simulatePlotSale");
        String username = tokenService.getUsernameFromToken(token);
        SimulateSalePlotResponseDto response = saleService.simulatePlotSale(idPlot,idCustomer, username, paymentCondition);
        log.info("[end] SaleController - simulatePlotSale");
        return response;
    }

    @Override
    public SaleResponseDTO executeSalePlot(String token, SaleRequestDTO saleRequestDTO) {
        log.info("[start] SaleController - executeSalePlot");
        String username = tokenService.getUsernameFromToken(token);
        SaleResponseDTO response = saleService.executeSalePlot(saleRequestDTO, username);
        log.info("[end] SaleController - executeSalePlot");
        return response;
    }
}
