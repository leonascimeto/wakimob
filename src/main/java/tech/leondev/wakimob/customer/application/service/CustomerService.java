package tech.leondev.wakimob.customer.application.service;

import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.customer.application.api.CustomerRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerCreateDTO);

    List<CustomerResponseDTO> list();

    CustomerResponseDTO getById(UUID idCustomer);

    void update(CustomerRequestDTO customerRequestDTO, UUID idCustomer);
}
