package tech.leondev.wakimob.realtor.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.credential.application.repository.CredentialRepository;
import tech.leondev.wakimob.credential.application.service.CredentialService;
import tech.leondev.wakimob.credential.domain.Credential;
import tech.leondev.wakimob.realtor.application.api.RealtorCreateDTO;
import tech.leondev.wakimob.realtor.application.api.RealtorResponseDTO;
import tech.leondev.wakimob.realtor.application.repository.RealtorRepository;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class RealtorApplicationService implements RealtorService{
    private final RealtorRepository realtorRepository;
    private final CredentialService credentialService;
    @Override
    public RealtorResponseDTO save(RealtorCreateDTO realtorCreateDTO) {
        log.info("[start] RealtorApplicationService - save");
        credentialService.save(realtorCreateDTO.username(), realtorCreateDTO.password());
        Realtor realtor = realtorRepository.save(new Realtor(realtorCreateDTO));
        log.info("[end] RealtorApplicationService - save");
        return new RealtorResponseDTO(realtor);
    }

    @Override
    public RealtorResponseDTO get(UUID idRealtor) {
        log.info("[start] RealtorApplicationService - get");
        Realtor realtor = realtorRepository.get(idRealtor);
        log.info("[end] RealtorApplicationService - get");
        return new RealtorResponseDTO(realtor);
    }

    @Override
    public Realtor getByUsername(String username) {
        log.info("[start] RealtorApplicationService - getByToken");
        Realtor realtor = realtorRepository.getByUsername(username);
        log.info("[end] RealtorApplicationService - getByToken");
        return null;
    }
}
