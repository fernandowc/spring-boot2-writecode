package springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class IncorrectOrderRequestException extends RuntimeException {

    public IncorrectOrderRequestException() {
        super();
    }

    public IncorrectOrderRequestException(String message) {
        super(message);
    }

    public IncorrectOrderRequestException(String message, Throwable cause, boolean enableSuppressing, boolean writableStackTrace) {
        super(message, cause, enableSuppressing, writableStackTrace);
    }



}
