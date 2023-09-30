package tech.leondev.wakimob.properties.application.repository;

import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.domain.Apartment;

import java.util.List;

public interface ApartmentRepository {
    Apartment save(Apartment apartment);

    List<Apartment> list();
}
