package tech.leondev.wakimob.customer.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.customer.application.repository.CustomerRepository;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.handler.ApiException;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class CustomerInfraRepository implements CustomerRepository {
    private final CustomerSpringDataJPARepository customerSpringDataJPARepository;

    @Override
    public Customer save(Customer customer) {
        log.info("[start] ClientInfraRepository - save");
        Customer clientSaved = customerSpringDataJPARepository.save(customer);
        log.info("[end] ClientInfraRepository - save");
        return clientSaved;
    }

    @Override
    public List<Customer> list() {
        log.info("[start] ClientInfraRepository - list");
        List<Customer> customers = customerSpringDataJPARepository.findAll();
        log.info("[end] ClientInfraRepository - list");
        return customers;
    }

    @Override
    public Customer getById(UUID idCustomer) {
        log.info("[start] ClientInfraRepository - getById");
        Customer customer = customerSpringDataJPARepository.findById(idCustomer)
                .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Customer not found"));
        log.info("[end] ClientInfraRepository - getById");
        return customer;
    }
}
