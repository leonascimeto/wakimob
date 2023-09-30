package tech.leondev.wakimob.auth.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.credential.application.repository.CredentialRepository;
import tech.leondev.wakimob.handler.ApiException;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService  {
    private final CredentialRepository credentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("[start] AuthorizationService - loadUserByUsername");
        UserDetails userDetails = credentialRepository.findByUsername(username);
        log.info("[end] AuthorizationService - loadUserByUsername");
        return Optional.of(userDetails).orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Credential not found"));
    }
}
