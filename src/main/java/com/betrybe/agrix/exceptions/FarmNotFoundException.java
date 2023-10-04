package com.betrybe.agrix.exceptions;

/**
 * Exceção para casos de busca sem resultado de Farm.
 */
public class FarmNotFoundException extends Exception {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
