package tech.leondev.wakimob.client.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteCreateDTO(
        @NotBlank
        @Size(min = 4, max = 80)
        String name,
        @NotBlank
        @Size(min = 11, max = 11)
        @CPF
        String cpf,
        @NotBlank
        @Size(min = 10, max = 20)
        String telephone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 4, max = 80)
        String address
) {
}

