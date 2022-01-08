package springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ExceptionHandlerr extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerAllException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
                request.getDescription(true),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return new ResponseEntity<Object>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectOrderRequestException.class)
    public ResponseEntity<Object> handlerIncorrectException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
                request.getDescription(true),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<Object>(response, response.getStatus());
    }
}
