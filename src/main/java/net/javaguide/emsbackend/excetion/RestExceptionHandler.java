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
// ================================  Not Found
  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<ResponseData> handleNotFoundException(ResourceNotFoundException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.NOT_FOUND.toString());
    res.setMessage(exception.getMessage());
    return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
  }
  // ================================  Bad Request
  @ExceptionHandler(value = ResourceBadRequestException.class)
  public ResponseEntity<ResponseData> handleBadRequestException(ResourceBadRequestException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.BAD_REQUEST.toString());
    res.setMessage(exception.getMessage());
    return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
  }
  // ================================  Handle on field
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleNotValidException(
      MethodArgumentNotValidException exception) {
    var res = new ResponseData();
    res.setStatus(HttpStatus.BAD_REQUEST.toString());
    StringBuilder str = new StringBuilder();
    var fieldErrors = exception.getBindingResult().getFieldErrors();

    for (var fieldError : fieldErrors) {
      str.append("{").append(fieldError.getField()).append(": ")
          .append(fieldError.getDefaultMessage()).append(" },");
    }

    res.setMessage(str.toString());
    return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
  }
}
