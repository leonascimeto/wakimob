package tech.leondev.wakimob.realtor.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/realtors")
@RestController
public interface RealtorAPI {


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    RealtorResponseDTO save(@RequestBody @Valid RealtorCreateDTO request);

    @GetMapping("/{idRealtor}")
    @ResponseStatus(HttpStatus.OK)
    RealtorResponseDTO get(@PathVariable UUID idRealtor);
}
