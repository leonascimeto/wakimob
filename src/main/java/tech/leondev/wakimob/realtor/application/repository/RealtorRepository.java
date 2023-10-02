package tech.leondev.wakimob.realtor.application.repository;

import tech.leondev.wakimob.realtor.domain.Realtor;

import java.util.UUID;

public interface RealtorRepository {
    Realtor save(Realtor realtor);

    Realtor get(UUID idRealtor);

    Realtor getByUsername(String username);
}
