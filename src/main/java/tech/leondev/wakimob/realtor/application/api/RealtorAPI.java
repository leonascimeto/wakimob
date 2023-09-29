package tech.leondev.wakimob.realtor.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/realtors")
@RestController
public interface RealtorAPI {
    @PostMapping
    RealtorResponseDTO save(@RequestBody @Valid RealtorCreateDTO request);

    @GetMapping("/{idRealtor}")
    RealtorResponseDTO get(@PathVariable UUID idRealtor);
}
