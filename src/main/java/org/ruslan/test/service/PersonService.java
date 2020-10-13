package org.ruslan.test.service;

import org.ruslan.test.service.model.PersonDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    int addPerson(PersonDTO personDTO);

    List<PersonDTO> showList();

    Optional<PersonDTO> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, PersonDTO personDTO);
}
