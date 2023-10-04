package com.betrybe.agrix.dtos.crop;

import java.time.LocalDate;

/**
 * Dto de Crop para limitar quais informações vou retornar para o cliente.
 */
public record CropDto(
    Integer id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Integer farmId) {

}
