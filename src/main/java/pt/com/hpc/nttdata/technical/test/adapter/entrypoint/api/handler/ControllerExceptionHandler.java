package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.api.handler;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pt.com.hpc.nttdata.technical.test.infra.exception.NotFoundException;

import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(NotFoundException ex, WebRequest request) {
        String body =
                "{\"message\":\"Não foi encontrado registro referente ao tipo [" + ex.getType() + "] para o id [" + ex.getId() + "] informado.\"}";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(new HttpHeaders()).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map body = null;//result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toMap());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(new HttpHeaders()).body(body);
    }

    /*
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {

        ex.;
        Map body = null;//result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toMap());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(new HttpHeaders()).body(body);
    }
    */
}
