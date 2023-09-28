package tech.leondev.wakimob.credential.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.credential.application.repository.CredentialRepository;
import tech.leondev.wakimob.credential.domain.Credential;
import tech.leondev.wakimob.realtor.application.api.RealtorCreateDTO;

@Log4j2
@RequiredArgsConstructor
@Service
public class CredentialApplicationService implements CredentialService{
    private final CredentialRepository credentialRepository;

    @Override
    public void save(String username, String password) {
        log.info("[start] CredentialApplicationService - saveRealtor");
        Credential credential = new Credential(username, password);
        credentialRepository.save(credential);
        log.info("[end] CredentialApplicationService - saveRealtor");
    }
}
