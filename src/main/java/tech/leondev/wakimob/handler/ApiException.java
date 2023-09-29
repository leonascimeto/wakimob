package tech.leondev.wakimob.handler;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serial;
import java.util.Optional;

@Log4j2
@Getter
public class ApiException  extends RuntimeException{
    private HttpStatus status;
    private ErrorApiResponse body;

    private ApiException(HttpStatus status, String message, Exception e){
        super(message, e);
        this.status = status;
        this.body = ErrorApiResponse.builder()
                .message(message)
                .description(getDescription(e))
                .build();
    }

    public static ApiException build(HttpStatus statusException, String message){
        return new ApiException(statusException, message, null);
    }

    public static ApiException build(HttpStatus statusException, String message, Exception e) {
        log.error("Exception: ", e);
        return new ApiException(statusException, message, e);
    }

    private String getDescription(Exception e) {
        return Optional.ofNullable(e)
                .map(ApiException::getMessageCause).orElse(null);
    }

    private static String getMessageCause(Exception e) {
        return e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
    }

    public ResponseEntity<ErrorApiResponse> buildErrorResponseEntity() {
        return ResponseEntity
                .status(status)
                .body(body);
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
