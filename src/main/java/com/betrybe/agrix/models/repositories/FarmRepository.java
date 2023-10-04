package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para criação do repository de Farm, o hibernate que irá implementar.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer> {
}
