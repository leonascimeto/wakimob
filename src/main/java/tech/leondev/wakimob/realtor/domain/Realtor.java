package tech.leondev.wakimob.realtor.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import tech.leondev.wakimob.credential.domain.Credential;
import tech.leondev.wakimob.realtor.application.api.RealtorCreateDTO;

import java.time.LocalDateTime;
import java.util.UUID;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "realtors")
@Entity(name = "realtors")
public class Realtor {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRealtor;
    @NotBlank
    @Size(min = 4, max = 80)
    private String name;
    @NotBlank
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;
    @NotNull
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id")
    Credential credential;

    public Realtor(RealtorCreateDTO realtorCreateDTO) {
        this.name = realtorCreateDTO.name();
        this.cpf = realtorCreateDTO.cpf();
        this.birthDate = realtorCreateDTO.birthDate();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
