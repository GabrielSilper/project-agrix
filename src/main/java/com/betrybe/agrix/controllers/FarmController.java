package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.crop.CropCreationDto;
import com.betrybe.agrix.dtos.crop.CropDto;
import com.betrybe.agrix.dtos.farm.FarmCreationDto;
import com.betrybe.agrix.dtos.farm.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
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
 * Camada de controle da entidade Farm, para tratar as requisições e respostas do endpoint
 * "/farms".
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  //  ------------- Rotas POST da aplicação. ----------------------
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return this.farmService.createFarm(farmCreationDto);
  }

  @PostMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(
      @RequestBody CropCreationDto cropCreationDto,
      @PathVariable Integer id
  ) throws FarmNotFoundException {
    return this.cropService.createCrop(id, cropCreationDto);
  }

  //  ------------- Rotas GET da aplicação. ----------------------
  @GetMapping
  public List<FarmDto> getAllFarms() {
    return this.farmService.getAllFarms();
  }

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Integer id) throws FarmNotFoundException {
    return this.farmService.getFarmById(id);
  }

  @GetMapping("/{id}/crops")
  public List<CropDto> getCropsByFarm(@PathVariable Integer id) throws FarmNotFoundException {
    return this.cropService.getCropsByFarm(id);
  }
}
