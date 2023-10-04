package com.betrybe.agrix.models.entities;

import com.betrybe.agrix.dtos.fertilizer.FertilizerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entidade Fertilizer.
 */
@Entity
@Table(name = "fertilizers")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String brand;

  private String composition;

  @ManyToMany(mappedBy = "fertilizers")
  private List<Crop> crops;

  public Fertilizer() {
  }

  /**
   * Construtor da entidade Fertilizer.
   */
  public Fertilizer(Integer id, String name, String brand, String composition, List<Crop> crops) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
    this.crops = crops;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }

  public FertilizerDto toDto() {
    return new FertilizerDto(id, name, brand, composition);
  }
}