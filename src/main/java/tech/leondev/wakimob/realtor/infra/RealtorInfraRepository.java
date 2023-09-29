package tech.leondev.wakimob.realtor.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.leondev.wakimob.handler.ApiException;
import tech.leondev.wakimob.realtor.application.repository.RealtorRepository;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class RealtorInfraRepository implements RealtorRepository {
    private final RealtorSpringDataJPARepository realtorSpringDataJPARepository;

    @Transactional
    @Override
    public Realtor save(Realtor realtor) {
        log.info("[start] RealtorInfraRepository - save");
        Realtor realtorSaved = realtorSpringDataJPARepository.save(realtor);
        log.info("[end] RealtorInfraRepository - save");
        return realtorSaved;
    }

    @Override
    public Realtor get(UUID idRealtor) {
        log.info("[start] RealtorInfraRepository - get");
        Realtor realtor = realtorSpringDataJPARepository.findById(idRealtor)
                        .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Realtor not found"));
        log.info("[end] RealtorInfraRepository - get");
        return realtor;
    }
}
