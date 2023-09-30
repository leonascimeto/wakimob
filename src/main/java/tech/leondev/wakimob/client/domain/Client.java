package tech.leondev.wakimob.client.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import tech.leondev.wakimob.client.application.api.ClienteCreateDTO;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "clients")
@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idClient;
    @NotBlank
    @Size(min = 4, max = 80)
    private String name;
    @NotBlank
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;
    @NotBlank
    @Size(min = 10, max = 20)
    private String telephone;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 80)
    private String address;

    public Client(ClienteCreateDTO clienteCreateDTO){
        this.name = clienteCreateDTO.name();
        this.cpf = clienteCreateDTO.cpf();
        this.telephone = clienteCreateDTO.telephone();
        this.email = clienteCreateDTO.email();
        this.address = clienteCreateDTO.address();
    }
}
