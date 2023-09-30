package tech.leondev.wakimob.credential.application.repository;

import org.springframework.security.core.userdetails.UserDetails;
import tech.leondev.wakimob.credential.domain.Credential;

public interface CredentialRepository {
    Credential save(Credential credential);
    UserDetails findByUsername(String username);
}
