package tech.leondev.wakimob.client.application.service;

import tech.leondev.wakimob.client.application.api.ClientResponseDTO;
import tech.leondev.wakimob.client.application.api.ClienteCreateDTO;

public interface ClientService {
    ClientResponseDTO save(ClienteCreateDTO clienteCreateDTO);
}
