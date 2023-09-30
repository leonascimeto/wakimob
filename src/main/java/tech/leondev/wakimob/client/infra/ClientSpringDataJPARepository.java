package tech.leondev.wakimob.client.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.client.domain.Client;

import java.util.UUID;

public interface ClientSpringDataJPARepository extends JpaRepository<Client, UUID> {
}
