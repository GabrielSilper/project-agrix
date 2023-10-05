package com.betrybe.agrix.dtos.person;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Dto para criação de uma pessoa.
 */
public record PersonCreationDto(String username, String password, Role role) {

  /**
   * Dto para entidade Person.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);

    return person;
  }
}
