package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.customer.domain.Customer;

public interface ClientRepository {
    Customer save(Customer client);
}
