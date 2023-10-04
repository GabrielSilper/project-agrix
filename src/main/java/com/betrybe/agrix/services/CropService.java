package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.crop.CropCreationDto;
import com.betrybe.agrix.dtos.crop.CropDto;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Camada de serviços para tratar as regras de negócios da plantação na aplicação.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;
  private final FertilizerRepository fertilizerRepository;

  /**
   * Construtor da classe CropService e recebe beans do Spring Boot.
   */
  public CropService(CropRepository cropRepository, FarmRepository farmRepository,
      FertilizerService fertilizerService, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Cria uma nova plantação e associa a uma fazenda.
   *
   * @throws FarmNotFoundException - Caso a fazenda passada não exista.
   */
  public CropDto createCrop(Integer farmId, CropCreationDto cropCreationDto)
      throws FarmNotFoundException {
    Optional<Farm> foundFarm = this.farmRepository.findById(farmId);
    if (foundFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    Crop creationCrop = cropCreationDto.toEntity();
    creationCrop.setFarm(foundFarm.get());

    return this.cropRepository.save(creationCrop).toDto();
  }

  /**
   * Retorna todas as plantações.
   */
  public List<CropDto> getAllCrops() {
    return this.cropRepository
        .findAll()
        .stream()
        .map(Crop::toDto)
        .toList();
  }

  /**
   * Retorna todas as plantações de uma fazenda específica.
   */
  public List<CropDto> getCropsByFarm(Integer farmId) throws FarmNotFoundException {
    Optional<Farm> foundFarm = this.farmRepository.findById(farmId);
    if (foundFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    return foundFarm
        .get()
        .getCrops()
        .stream()
        .map(Crop::toDto)
        .toList();
  }

  /**
   * Retorna uma plantação específica.
   */
  public CropDto getCropById(Integer id) throws CropNotFoundException {
    return this.cropRepository
        .findById(id)
        .orElseThrow(CropNotFoundException::new)
        .toDto();
  }

  /**
   * Retorna todas as plantações baseado na data de colheita.
   */
  public List<CropDto> getCropsByHarvestDate(LocalDate start, LocalDate end) {
    return this.cropRepository
        .findAllCropByHarvestDate(start, end)
        .stream()
        .map(Crop::toDto)
        .toList();
  }

  /**
   * Associa um fertilizante a uma plantação.
   */
  public void associateFertilizerToCrop(Integer cropId, Integer fertilizerId)
      throws FertilizerNotFoundException, CropNotFoundException {
    //Essa função me ensinou que é melhor retornar a entidade nos métodos dos meus services
    // em vez de já mandar o Dto, pois eu poderia ter simplificado usando os services aqui
    // aprendi aqui uma lição valiosa.
    // Irei refatorar depois.
    Optional<Crop> crop = this.cropRepository.findById(cropId);
    Optional<Fertilizer> fertilizer = this.fertilizerRepository.findById(fertilizerId);

    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }

    if (fertilizer.isEmpty()) {
      throw new FertilizerNotFoundException();
    }

    crop.get().getFertilizers().add(fertilizer.get());

    this.cropRepository.save(crop.get());
  }

  /**
   * Retorna todos os fertilizantes associados a uma plantação.
   */
  public List<Fertilizer> getFertilizersByCrop(Integer cropId) throws CropNotFoundException {
    Optional<Crop> crop = this.cropRepository.findById(cropId);

    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }

    return crop.get().getFertilizers();
  }
}
