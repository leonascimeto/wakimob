package tech.leondev.wakimob.auth.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.credential.domain.Credential;
import tech.leondev.wakimob.handler.ApiException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class TokenService {
    @Value("${api.securiry.token.secret}")
    private String secret;
    public String generateToken(Credential credential){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(credential.getUsername())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException ex){
            throw ApiException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Error while generating token");
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex){
            throw ApiException.build(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
    }

    public String getUsernameFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT decodedJWT = JWT.decode(token.replace("Bearer ", ""));
            return decodedJWT.getSubject();
        } catch (Exception ex){
            throw ApiException.build(HttpStatus.BAD_REQUEST, "Invalid token");
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
