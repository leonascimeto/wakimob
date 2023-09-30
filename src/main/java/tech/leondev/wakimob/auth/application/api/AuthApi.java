package tech.leondev.wakimob.auth.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/auth")
public interface AuthApi {
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    AuthResponseDTO login(@RequestBody @Valid AuthLoginDTO authLoginDTO);
}
