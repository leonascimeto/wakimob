package tech.leondev.wakimob.properties.application.repository;

import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.domain.Apartment;

import java.util.List;
import java.util.UUID;

public interface ApartmentRepository {
    Apartment save(Apartment apartment);

    List<Apartment> list();

    Apartment getById(UUID apartmentId);

    void delete(Apartment apartment);
}
