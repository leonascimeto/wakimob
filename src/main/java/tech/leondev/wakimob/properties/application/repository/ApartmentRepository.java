package tech.leondev.wakimob.properties.application.repository;

import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.domain.Apartment;

public interface ApartmentRepository {
    Apartment save(Apartment apartment);

}
