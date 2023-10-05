package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.response.ErrorMessageResponse;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe para lidar com as exceções criadas pela aplicação.
 */
@ControllerAdvice
public class ExceptionController {

  /**
   * Lida com exceções de entidades não encontras por uma busca.
   */
  @ExceptionHandler({
      FarmNotFoundException.class,
      CropNotFoundException.class,
      FertilizerNotFoundException.class
  })
  public ResponseEntity<ErrorMessageResponse> notFoundExceptionHandler(Exception e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorMessageResponse(e.getMessage()));
  }

  /**
   * Lida com a exceção de quando o login não foi bem-sucedido.
   */
  @ExceptionHandler({AuthenticationException.class, UsernameNotFoundException.class})
  public ResponseEntity<ErrorMessageResponse> authenticationExceptionHandler(Exception e) {
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(new ErrorMessageResponse(e.getMessage()));
  }

  /**
   * Lida com exceções imprevistas na aplicação.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessageResponse> generalExceptionHandler(Exception e) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorMessageResponse(e.getMessage()));
  }
}
