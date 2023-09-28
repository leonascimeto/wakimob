package tech.leondev.wakimob.realtor.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.leondev.wakimob.realtor.application.repository.RealtorRepository;
import tech.leondev.wakimob.realtor.domain.Realtor;

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
}
