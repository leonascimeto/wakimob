package tech.leondev.wakimob.customer.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.customer.domain.Customer;

import java.util.UUID;

public interface CustomerSpringDataJPARepository extends JpaRepository<Customer, UUID> {
}
