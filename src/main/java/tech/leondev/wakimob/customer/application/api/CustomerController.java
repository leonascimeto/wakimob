package tech.leondev.wakimob.client.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.client.application.service.ClientService;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ClientController implements ClientApi{
    private final ClientService clientService;
    @Override
    public ClientResponseDTO save(ClienteCreateDTO clienteCreateDTO) {
        log.info("[start] ClientController - save");
        ClientResponseDTO response = clientService.save(clienteCreateDTO);
        log.info("[end] ClientController - save");
        return response;
    }
}
