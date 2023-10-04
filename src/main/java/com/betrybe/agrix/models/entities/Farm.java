package com.betrybe.agrix.models.entities;

import com.betrybe.agrix.dtos.farm.FarmDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entidade Farm - representa a fazenda na aplicação.
 */
@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Double size;

  @JsonIgnore
  @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
  private List<Crop> crops;

  public Farm() {
  }

  /**
   * Construtor overload da entidade Farm.
   *
   * @param id    - Integer - o identificador único.
   * @param name  - String - o nome da fazenda.
   * @param size  - Double - o tamanho da fazendo
   * @param crops - Crop - as plantações relacionadas com a fazenda.
   */
  public Farm(Integer id, String name, Double size, List<Crop> crops) {
    this.id = id;
    this.name = name;
    this.size = size;
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

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }

  public FarmDto toDto() {
    return new FarmDto(id, name, size);
  }
}
