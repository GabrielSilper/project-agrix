package com.betrybe.agrix.exceptions;

/**
 * Exceção para quando não encontrar uma plantação em uma busca.
 */
public class CropNotFoundException extends Exception {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
