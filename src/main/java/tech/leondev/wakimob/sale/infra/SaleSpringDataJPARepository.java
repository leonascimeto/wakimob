package tech.leondev.wakimob.sale.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakimob.sale.domain.Sale;

import java.util.UUID;

public interface SaleSpringDataJPARepository extends JpaRepository<Sale, UUID> {
}
