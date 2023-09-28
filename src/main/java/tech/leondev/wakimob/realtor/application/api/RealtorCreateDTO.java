package tech.leondev.wakimob.realtor.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public record RealtorCreateDTO(@NotBlank @Size(min = 6, max = 12) String username,
                               @NotBlank @Size(min = 6, max = 20) String password,
                               @NotBlank @Size(min = 4, max = 80) String name,
                               @NotBlank @Size(min = 11, max = 11) @CPF String cpf, @NotNull LocalDateTime birthDate) {
}
