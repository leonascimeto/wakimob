package tech.leondev.wakimob.properties.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.properties.domain.Plot;

import java.util.UUID;

public interface PlotSpringDataJPARepository extends JpaRepository<Plot, UUID> {
}
