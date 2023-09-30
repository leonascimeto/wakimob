package tech.leondev.wakimob.properties.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.properties.domain.Apartment;

import java.util.UUID;

public interface ApartmentSpringDataJPARepository extends JpaRepository<Apartment, UUID> {
}
