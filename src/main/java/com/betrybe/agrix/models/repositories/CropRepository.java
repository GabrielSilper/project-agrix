package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interface para criação do repository de Crop, o hibernate que irá implementar.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

  @Query(value = "SELECT * FROM crops "
      + "WHERE harvest_date BETWEEN :start AND :end",
      nativeQuery = true)
  public List<Crop> findAllCropByHarvestDate(@Param("start") LocalDate start,
      @Param("end") LocalDate end);
}
