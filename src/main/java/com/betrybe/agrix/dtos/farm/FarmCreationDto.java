package com.betrybe.agrix.dtos.farm;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Dto para auxiliar na criação de uma nova instância de Farm.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * Método para criar uma instância de Farm baseado no que foi passado para o Dto.
   */
  public Farm toEntity() {
    return new Farm(null, name, size, null);
  }
}
