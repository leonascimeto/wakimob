package tech.leondev.wakimob.credential.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.leondev.wakimob.realtor.application.api.RealtorCreateDTO;

import java.util.Collection;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "credentials")
@Entity(name = "credentials")
public class Credential implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCredential;
    @NotBlank
    @Size(min = 6, max = 12)
    @Column(unique = true)
    private String username;
    @NotBlank
    @Size(min = 6, max = 200)
    private String password;

    public Credential(String username, String password){
        this.username = username;
        var encrypt = new BCryptPasswordEncoder();
        this.password = encrypt.encode(password);
    }

    public void encryptPassword(){
        var encrypt = new BCryptPasswordEncoder();
        this.password = encrypt.encode(this.password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
