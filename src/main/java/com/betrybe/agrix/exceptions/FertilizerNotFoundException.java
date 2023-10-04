package com.betrybe.agrix.exceptions;

/**
 * Exceção para quando um fertilizante não for encontrado.
 */
public class FertilizerNotFoundException extends Exception {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
