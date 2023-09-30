package tech.leondev.wakimob.customer.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/customers")
public interface CustomerApi {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    CustomerResponseDTO save(@RequestBody @Valid CustomerRequestDTO customerCreateDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CustomerResponseDTO> list();

    @GetMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    CustomerResponseDTO get(@PathVariable UUID idCustomer);

    @PatchMapping("/{idCustomer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody @Valid CustomerRequestDTO customerRequestDTO, @PathVariable UUID idCustomer);
}
