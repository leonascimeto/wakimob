package tech.leondev.wakimob.client.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.client.domain.Client;
import tech.leondev.wakimob.realtor.application.repository.ClientRepository;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ClientInfraRepository implements ClientRepository {
    private final ClientSpringDataJPARepository clientSpringDataJPARepository;
    @Override
    public Client save(Client client) {
        log.info("[start] ClientInfraRepository - save");
        Client clientSaved = clientSpringDataJPARepository.save(client);
        log.info("[end] ClientInfraRepository - save");
        return clientSaved;
    }
}
