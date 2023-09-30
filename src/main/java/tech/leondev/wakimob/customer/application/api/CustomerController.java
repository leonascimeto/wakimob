package tech.leondev.wakimob.customer.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.customer.application.service.CustomerService;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CustomerController implements CustomerApi {
    private final CustomerService customerService;
    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerCreateDTO) {
        log.info("[start] ClientController - save");
        CustomerResponseDTO response = customerService.save(customerCreateDTO);
        log.info("[end] ClientController - save");
        return response;
    }

    @Override
    public List<CustomerResponseDTO> list() {
        log.info("[start] ClientController - list");
        List<CustomerResponseDTO> response = customerService.list();
        log.info("[end] ClientController - list");
        return response;
    }

    @Override
    public CustomerResponseDTO get(UUID idCustomer) {
        log.info("[start] ClientController - get");
        CustomerResponseDTO response = customerService.getById(idCustomer);
        log.info("[end] ClientController - get");
        return response;
    }

    @Override
    public void update(CustomerRequestDTO customerRequestDTO, UUID idCustomer) {
        log.info("[start] ClientController - list");
        customerService.update(customerRequestDTO, idCustomer);
        log.info("[end] ClientController - list");
    }
}
