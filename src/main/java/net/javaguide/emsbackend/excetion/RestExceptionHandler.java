package net.javaguide.emsbackend.excetion;

import lombok.extern.slf4j.Slf4j;
import net.javaguide.emsbackend.excetion.model.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.NOT_FOUND.toString());
    res.setMessage(exception.getMessage());
    return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = ResourceBadRequestException.class)
  public ResponseEntity<Object> handleBadRequestException(ResourceBadRequestException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.BAD_REQUEST.toString());
    res.setMessage(exception.getMessage());
    return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleBadRequestException(
      MethodArgumentNotValidException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.BAD_REQUEST.toString());
    res.setMessage(exception.getMessage());

    StringBuilder str = new StringBuilder();
    var fieldErrors = exception.getBindingResult().getFieldErrors();

    for (var fieldError : fieldErrors) {
      str.append(" Field: ").append(fieldError.getField()).append(" Because: ")
          .append(fieldError.getDefaultMessage()).append(" ,");
    }

    res.setMessage(str.toString());
    return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
  }
}
