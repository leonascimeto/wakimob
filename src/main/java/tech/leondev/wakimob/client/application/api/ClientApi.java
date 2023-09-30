package tech.leondev.wakimob.client.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clients")
public interface ClientApi {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ClientResponseDTO save(@RequestBody @Valid ClienteCreateDTO clienteCreateDTO);
}
