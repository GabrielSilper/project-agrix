package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.fertilizer.FertilizerCreationDto;
import com.betrybe.agrix.dtos.fertilizer.FertilizerDto;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Camada de controle da entidade Fertilizer.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    return this.fertilizerService.createFertilizer(fertilizerCreationDto);
  }

  @GetMapping
  public List<FertilizerDto> getAllFertilizers() {
    return this.fertilizerService.getAllFertilizers();
  }

  @GetMapping("/{id}")
  public FertilizerDto getFertilizerById(@PathVariable Integer id)
      throws FertilizerNotFoundException {
    return this.fertilizerService.getFertilizerById(id);
  }
}
