package com.lore.demo.Api;

import com.lore.demo.Exception.ApplicationError;
import com.lore.demo.Exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @Value("${api_doc_url}")
  private String detail;

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest)
  {
    ApplicationError error = new ApplicationError();
    error.setCode(101);
    error.setMessage(exception.getMessage());
    error.setDetail(detail);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
