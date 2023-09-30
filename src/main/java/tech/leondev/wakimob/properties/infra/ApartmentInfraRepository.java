package tech.leondev.wakimob.properties.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.application.repository.ApartmentRepository;
import tech.leondev.wakimob.properties.domain.Apartment;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ApartmentInfraRepository implements ApartmentRepository {
    private final ApartmentSpringDataJPARepository apartmentSpringDataJPARepository;
    @Override
    public Apartment save(Apartment apartment) {
        log.info("[start] ApartmentInfraRepository - save");
        Apartment apartmentSaved = apartmentSpringDataJPARepository.save(apartment);
        log.info("[end] ApartmentInfraRepository - save");
        return apartmentSaved;
    }

    @Override
    public List<Apartment> list() {
        log.info("[start] ApartmentInfraRepository - list");
        List<Apartment> apartments = apartmentSpringDataJPARepository.findAll();
        log.info("[end] ApartmentInfraRepository - list");
        return apartments;
    }
}
