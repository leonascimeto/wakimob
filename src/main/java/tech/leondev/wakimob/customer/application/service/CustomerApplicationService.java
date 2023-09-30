package tech.leondev.wakimob.customer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.customer.application.api.CustomerCreateDTO;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.realtor.application.repository.ClientRepository;

@RequiredArgsConstructor
@Log4j2
@Service
public class ClientApplicationService implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public CustomerResponseDTO save(CustomerCreateDTO customerCreateDTO) {
        log.info("[start] ClientApplicationService - save");
        Customer customer = clientRepository.save(new Customer(customerCreateDTO));
        log.info("[end] ClientApplicationService - save");
        return new CustomerResponseDTO(customer);
    }
}
