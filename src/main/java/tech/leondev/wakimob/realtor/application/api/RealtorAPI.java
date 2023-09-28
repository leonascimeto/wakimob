package tech.leondev.wakimob.realtor.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/realtors")
@RestController
public interface RealtorAPI {
    @PostMapping
    RealtorResponseDTO save(@RequestBody @Valid RealtorCreateDTO request);
}
