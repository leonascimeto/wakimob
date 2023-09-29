package tech.leondev.wakimob.realtor.application.service;

import tech.leondev.wakimob.realtor.application.api.RealtorCreateDTO;
import tech.leondev.wakimob.realtor.application.api.RealtorResponseDTO;

import java.util.UUID;

public interface RealtorService {
    RealtorResponseDTO save(RealtorCreateDTO realtorCreateDTO);

    RealtorResponseDTO get(UUID idRealtor);
}
