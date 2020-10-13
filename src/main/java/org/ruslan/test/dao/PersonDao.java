package org.ruslan.test.dao;

import org.ruslan.test.service.model.PersonDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson (PersonDTO personDTO);

    List<PersonDTO> showList();

    Optional<PersonDTO> selectPersonById(UUID id);

    int updatePersonById(UUID id, PersonDTO personDTO);

    int deletePersonById(UUID id);
}
