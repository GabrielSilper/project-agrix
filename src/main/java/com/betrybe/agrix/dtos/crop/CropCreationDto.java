package com.betrybe.agrix.dtos.crop;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import java.time.LocalDate;
import java.util.List;

/**
 * Dto para auxiliar na criação de entidades do tipo Crop.
 */
public record CropCreationDto(
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    List<Fertilizer> fertilizers) {
  public Crop toEntity() {
    return new Crop(null, name, plantedArea, null, plantedDate, harvestDate, fertilizers);
  }
}
