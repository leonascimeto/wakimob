package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.client.domain.Client;

public interface ClientRepository {
    Client save(Client client);
}
