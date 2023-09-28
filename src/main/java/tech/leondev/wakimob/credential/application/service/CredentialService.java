package tech.leondev.wakimob.credential.application.service;

import org.springframework.stereotype.Service;
import tech.leondev.wakimob.credential.domain.Credential;

@Service
public interface CredentialService {
    void save(String username, String password);
}
