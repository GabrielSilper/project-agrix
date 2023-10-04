package com.betrybe.agrix.dtos.fertilizer;

import com.betrybe.agrix.models.entities.Fertilizer;

/**
 * Dto para criar uma nova entidade Fertilizer.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

  public Fertilizer toEntity() {
    return new Fertilizer(null, name, brand, composition, null);
  }
}
