package tech.leondev.wakimob.customer.application.service;

import tech.leondev.wakimob.customer.application.api.CustomerResponseDTO;
import tech.leondev.wakimob.customer.application.api.CustomerCreateDTO;

public interface ClientService {
    CustomerResponseDTO save(CustomerCreateDTO customerCreateDTO);
}
