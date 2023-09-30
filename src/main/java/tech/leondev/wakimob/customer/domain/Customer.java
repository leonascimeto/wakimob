package tech.leondev.wakimob.customer.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import tech.leondev.wakimob.customer.application.api.CustomerRequestDTO;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "customers")
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idCustomer;
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

    public Customer(CustomerRequestDTO customerRequestDTO){
        this.name = customerRequestDTO.name();
        this.cpf = customerRequestDTO.cpf();
        this.telephone = customerRequestDTO.telephone();
        this.email = customerRequestDTO.email();
        this.address = customerRequestDTO.address();
    }

    public void update(CustomerRequestDTO customerRequestDTO) {
        this.name = customerRequestDTO.name();
        this.cpf = customerRequestDTO.cpf();
        this.telephone = customerRequestDTO.telephone();
        this.email = customerRequestDTO.email();
        this.address = customerRequestDTO.address();
    }
}
