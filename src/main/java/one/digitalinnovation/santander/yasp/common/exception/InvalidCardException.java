package one.digitalinnovation.santander.yasp.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid card")
public class InvalidCardException extends RuntimeException {
}
