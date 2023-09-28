package tech.leondev.wakimob.realtor.application.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakimob.credential.application.service.CredentialService;
import tech.leondev.wakimob.realtor.application.service.RealtorService;

@Log4j2
@RequiredArgsConstructor
@RestController
public class RealtorController implements RealtorAPI{
    private final RealtorService realtorService;
    @Override
    public RealtorResponseDTO save(@Valid RealtorCreateDTO request) {
        log.info("[start] RealtorController - save");
        RealtorResponseDTO response = realtorService.save(request);
        log.info("[start] RealtorController - save");
        return response;
    }
}
