package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.person.PersonCreationDto;
import com.betrybe.agrix.dtos.person.PersonDto;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Camada de controle da entidade Person.
 */
@RestController
@RequestMapping("persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody PersonCreationDto data) {
    return this.personService.create(data.toEntity()).toDto();
  }
}
