package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.crop.CropDto;
import com.betrybe.agrix.dtos.fertilizer.FertilizerDto;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Camada de controle da entidade Crop, para tratar as requisições e respostas do endpoint
 * "/crops".
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping
  public List<CropDto> getAllCrops() {
    return this.cropService.getAllCrops();
  }

  @GetMapping("/{id}")
  public CropDto getCropById(@PathVariable Integer id) throws CropNotFoundException {
    return this.cropService.getCropById(id);
  }

  @GetMapping("/search")
  public List<CropDto> getCropsByHarvestDate(
      @RequestParam LocalDate start, LocalDate end
  ) {
    return this.cropService.getCropsByHarvestDate(start, end);
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String associateFertilizerToCrop(@PathVariable Integer cropId,
      @PathVariable Integer fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    this.cropService.associateFertilizerToCrop(cropId, fertilizerId);
    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Rota para pegar os fertilizantes de uma plantação.
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> getFertilizersByCrop(@PathVariable Integer cropId)
      throws CropNotFoundException {
    return this.cropService
        .getFertilizersByCrop(cropId)
        .stream()
        .map(Fertilizer::toDto)
        .toList();
  }
}
