package tech.leondev.wakimob.sale.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tech.leondev.wakimob.sale.domain.PaymentCondition;

import java.util.UUID;

@RestController
@RequestMapping("v1/sales")
public interface SaleApi {
    @GetMapping("/plots/{idPlot}/customers/{idCustomer}/payment-conditions/{paymentCondition}/simulator")
    SimulateSaleResponseDTO simulatePlotSale(@RequestHeader(name = "Authorization",required = true) String token, @PathVariable UUID idPlot, @PathVariable UUID idCustomer,
                                             @PathVariable PaymentCondition paymentCondition);

    @PostMapping("/plots")
    SaleResponseDTO executeSalePlot(@RequestHeader(name = "Authorization",required = true) String token,
                                   @RequestBody @Valid SaleRequestDTO saleRequestDTO);

    @GetMapping("/apartments/{idApartment}/customers/{idCustomer}/payment-conditions/{paymentCondition}/simulator")
    SimulateSaleResponseDTO simulateApartmentSale(@RequestHeader(name = "Authorization",required = true) String token,
                                                           @PathVariable UUID idApartment, @PathVariable UUID idCustomer,
                                                           @PathVariable PaymentCondition paymentCondition);

    @PostMapping("/apartments")
    SaleResponseDTO executeApartment(@RequestHeader(name = "Authorization", required = true) String token,
                                     @RequestBody @Valid SaleRequestDTO saleRequestDTO);
}
