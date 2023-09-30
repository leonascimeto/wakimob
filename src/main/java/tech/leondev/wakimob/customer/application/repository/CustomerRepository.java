package tech.leondev.wakimob.customer.application.repository;

import tech.leondev.wakimob.customer.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer client);

    List<Customer> list();

    Customer getById(UUID idCustomer);
}
