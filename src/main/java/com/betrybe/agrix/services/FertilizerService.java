package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.fertilizer.FertilizerCreationDto;
import com.betrybe.agrix.dtos.fertilizer.FertilizerDto;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Camada de serviço da entidade Fertilizer.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public FertilizerDto createFertilizer(FertilizerCreationDto fertilizerCreationDto) {
    Fertilizer newFertilizer = fertilizerCreationDto.toEntity();
    return this.fertilizerRepository.save(newFertilizer).toDto();
  }

  /**
   * Retorna todos os fertilizantes salvos.
   */
  public List<FertilizerDto> getAllFertilizers() {
    return this.fertilizerRepository
        .findAll()
        .stream()
        .map(Fertilizer::toDto)
        .toList();
  }

  /**
   * Retorna um fertilizante específico.
   */
  public FertilizerDto getFertilizerById(Integer id) throws FertilizerNotFoundException {
    Optional<Fertilizer> fertilizer = this.fertilizerRepository.findById(id);

    return fertilizer.orElseThrow(FertilizerNotFoundException::new).toDto();
  }
}
