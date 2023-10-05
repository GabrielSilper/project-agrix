package com.betrybe.agrix.dtos.person;

import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Dto de resposta de uma entidade Person.
 */
public record PersonDto(Long id, String username, Role role) {

}
