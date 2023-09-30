package tech.leondev.wakimob.credential.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import tech.leondev.wakimob.credential.domain.Credential;

import java.util.UUID;

public interface CredentialSpringDataJPARepository extends JpaRepository<Credential, UUID> {
    UserDetails findByUsername(String username);
}
