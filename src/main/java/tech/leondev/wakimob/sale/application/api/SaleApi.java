package tech.leondev.wakimob.sale.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.sale.domain.PaymentCondition;

import java.util.UUID;

@RestController
@RequestMapping("v1/sales")
public interface SaleApi {
    @GetMapping("/plots/{idPlot}/customers/{idCustomer}/payment-conditions/{paymentCondition}/simulator")
    SimulateSalePlotResponseDto simulatePlotSale(@RequestHeader(name = "Authorization",required = true) String token, @PathVariable UUID idPlot, @PathVariable UUID idCustomer,
                                                 @PathVariable PaymentCondition paymentCondition);

    @PostMapping("/plots")
    SaleResponseDTO executeSalePlot(@RequestHeader(name = "Authorization",required = true) String token,
                                   @RequestBody @Valid SaleRequestDTO saleRequestDTO);
}
