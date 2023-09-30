package tech.leondev.wakimob.client.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.client.application.api.ClientResponseDTO;
import tech.leondev.wakimob.client.application.api.ClienteCreateDTO;
import tech.leondev.wakimob.client.domain.Client;
import tech.leondev.wakimob.realtor.application.repository.ClientRepository;

@RequiredArgsConstructor
@Log4j2
@Service
public class ClientApplicationService implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public ClientResponseDTO save(ClienteCreateDTO clienteCreateDTO) {
        log.info("[start] ClientApplicationService - save");
        Client client = clientRepository.save(new Client(clienteCreateDTO));
        log.info("[end] ClientApplicationService - save");
        return new ClientResponseDTO(client);
    }
}
