package tech.leondev.wakimob.customer.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.realtor.application.repository.ClientRepository;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ClientInfraRepository implements ClientRepository {
    private final ClientSpringDataJPARepository clientSpringDataJPARepository;
    @Override
    public Customer save(Customer customer) {
        log.info("[start] ClientInfraRepository - save");
        Customer clientSaved = clientSpringDataJPARepository.save(customer);
        log.info("[end] ClientInfraRepository - save");
        return clientSaved;
    }
}
