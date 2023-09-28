package tech.leondev.wakimob.realtor.application.api;

import lombok.Value;
import tech.leondev.wakimob.realtor.domain.Realtor;

import java.util.UUID;

@Value
public class RealtorResponseDTO{
    private UUID idUser;
    private String name;

    public RealtorResponseDTO(Realtor realtor) {
        this.idUser = realtor.getIdRealtor();
        this.name = realtor.getName();
    }
}
