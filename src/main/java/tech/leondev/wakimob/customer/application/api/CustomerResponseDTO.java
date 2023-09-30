package tech.leondev.wakimob.customer.application.api;

import lombok.Value;
import tech.leondev.wakimob.customer.domain.Customer;

@Value
public class ClientResponseDTO {
    private String name;
    private String cpf;
    private String telephone;
    private String email;
    private String address;

    public ClientResponseDTO(Customer client) {
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.telephone = client.getTelephone();
        this.email = client.getEmail();
        this.address = client.getAddress();
    }
}
