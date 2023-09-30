package tech.leondev.wakimob.customer.application.api;

import lombok.Value;
import tech.leondev.wakimob.customer.domain.Customer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class CustomerResponseDTO {
    private UUID id;
    private String name;
    private String cpf;
    private String telephone;
    private String email;
    private String address;

    public CustomerResponseDTO(Customer client) {
        this.id  = client.getIdCustomer();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.telephone = client.getTelephone();
        this.email = client.getEmail();
        this.address = client.getAddress();
    }

    public static List<CustomerResponseDTO> convertCustomerToList(List<Customer> customers) {
        return customers.stream().map(CustomerResponseDTO::new).collect(Collectors.toList());
    }
}
