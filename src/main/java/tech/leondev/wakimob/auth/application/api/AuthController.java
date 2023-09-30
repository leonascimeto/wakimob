package tech.leondev.wakimob.auth.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.auth.application.service.TokenService;
import tech.leondev.wakimob.credential.domain.Credential;

@Log4j2
@RequiredArgsConstructor
@RestController
public class AuthController implements AuthApi{
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public AuthResponseDTO login(AuthLoginDTO authLoginDTO) {
        log.info("[start] AuthController - authenticationDTO");
        var usernamePassword = new UsernamePasswordAuthenticationToken(authLoginDTO.login(), authLoginDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Credential) auth.getPrincipal());
        log.info("[end] AuthController - authenticationDTO");
        return new AuthResponseDTO(token);
    }
}
