package tech.leondev.wakimob.customer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.customer.application.api.CustomerRequestDTO;
import tech.leondev.wakimob.customer.application.repository.CustomerRepository;
import tech.leondev.wakimob.customer.domain.Customer;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class CustomerApplicationService implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        log.info("[start] ClientApplicationService - save");
        Customer customer = customerRepository.save(new Customer(customerRequestDTO));
        log.info("[end] ClientApplicationService - save");
        return new CustomerResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> list() {
        log.info("[start] ClientApplicationService - list");
        List<Customer> customers = customerRepository.list();
        log.info("[end] ClientApplicationService - list");
        return CustomerResponseDTO.convertCustomerToList(customers);
    }

    @Override
    public CustomerResponseDTO getById(UUID idCustomer) {
        log.info("[start] ClientApplicationService - getById");
        Customer customer = customerRepository.getById(idCustomer);
        log.info("[end] ClientApplicationService - getById");
        return new CustomerResponseDTO(customer);
    }

    @Override
    public void update(CustomerRequestDTO customerRequestDTO, UUID idCustomer) {
        log.info("[start] ClientApplicationService - update");
        Customer customer = customerRepository.getById(idCustomer);
        customer.update(customerRequestDTO);
        customerRepository.save(customer);
        log.info("[end] ClientApplicationService - update");
    }
}
