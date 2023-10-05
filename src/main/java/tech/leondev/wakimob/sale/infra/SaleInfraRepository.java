package tech.leondev.wakimob.sale.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.sale.application.repository.SaleRepository;
import tech.leondev.wakimob.sale.domain.Sale;
import tech.leondev.wakimob.sale.domain.SaleApartment;
import tech.leondev.wakimob.sale.domain.SalePlot;

@Log4j2
@RequiredArgsConstructor
@Repository
public class SaleInfraRepository implements SaleRepository {
    private final SaleSpringDataJPARepository saleSpringDataJPARepository;
    @Override
    public SalePlot savePlot(SalePlot salePlot) {
        log.info("[start] SaleInfraRepository - salePlot");
        SalePlot sale = saleSpringDataJPARepository.save(salePlot);
        log.info("[end] SaleInfraRepository - salePlot");
        return sale;
    }

    @Override
    public SaleApartment saveApartment(SaleApartment saleApartment) {
        log.info("[start] SaleInfraRepository - saveApartment");
        SaleApartment sale = saleSpringDataJPARepository.save(saleApartment);
        log.info("[end] SaleInfraRepository - saveApartment");
        return sale;
    }
}
