package tech.leondev.wakimob.realtor.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.util.Optional;
import java.util.UUID;

public interface RealtorSpringDataJPARepository extends JpaRepository<Realtor, UUID> {
    Optional<Realtor> findByUsername(String username);
}
