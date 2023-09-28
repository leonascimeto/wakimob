package tech.leondev.wakimob.credential.application.repository;

import tech.leondev.wakimob.credential.domain.Credential;
import tech.leondev.wakimob.realtor.domain.Realtor;

public interface CredentialRepository {
    Credential save(Credential credential);
}
