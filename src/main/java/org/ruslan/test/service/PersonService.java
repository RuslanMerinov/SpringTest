package org.ruslan.test.service;

import org.ruslan.test.dao.model.Person;
import org.ruslan.test.service.model.PersonDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    boolean addPerson(PersonDTO personDTO);

    List<Person> showList();

    Optional<Person> selectPersonById(UUID id);

    boolean deletePersonById(UUID id);

    boolean updatePersonById(UUID id, PersonDTO personDTO);
}
