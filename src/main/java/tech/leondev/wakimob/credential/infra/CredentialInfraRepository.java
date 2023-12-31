package tech.leondev.wakimob.credential.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.leondev.wakimob.credential.application.repository.CredentialRepository;
import tech.leondev.wakimob.credential.domain.Credential;

@Log4j2
@RequiredArgsConstructor
@Repository
public class CredentialInfraRepository implements CredentialRepository {
    private final CredentialSpringDataJPARepository credentialSpringDataJPARepository;

    @Transactional
    @Override
    public Credential save(Credential credential) {
        log.info("[start] CredentialInfraRepository - save");
        Credential credentialSaved = credentialSpringDataJPARepository.save(credential);
        log.info("[end] CredentialInfraRepository - save");
        return credentialSaved;
    }

    @Override
    public UserDetails findByUsername(String username) {
        log.info("[start] CredentialInfraRepository - findByUsername");
        UserDetails credential = credentialSpringDataJPARepository.findByUsername(username);
        log.info("[end] CredentialInfraRepository - findByUsername");
        return credential;
    }
}
