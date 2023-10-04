package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.farm.FarmCreationDto;
import com.betrybe.agrix.dtos.farm.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de serviço para tratar as regras de negócios com os dados vindo do repository de Farm.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Salva uma nova fazenda.
   */
  public FarmDto createFarm(FarmCreationDto farmCreationDto) {
    return this.farmRepository
        .save(farmCreationDto.toEntity())
        .toDto();
  }

  /**
   * Lista todos as fazendas.
   */
  public List<FarmDto> getAllFarms() {
    return this.farmRepository
        .findAll()
        .stream()
        .map(Farm::toDto)
        .toList();
  }

  /**
   * Retorna uma fazenda específica.
   */
  public FarmDto getFarmById(Integer id) throws FarmNotFoundException {
    return this.farmRepository
        .findById(id)
        .orElseThrow(FarmNotFoundException::new)
        .toDto();
  }
}
