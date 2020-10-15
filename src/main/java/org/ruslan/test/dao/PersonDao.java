package org.ruslan.test.dao;

import org.ruslan.test.dao.model.Person;
import org.ruslan.test.service.model.PersonDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    boolean addPerson (Person person);

    List<Person> getList();

//    Optional<Person> selectPersonById(UUID id);

    List<Person> selectNewPersonById(UUID id);

    boolean updatePersonById(UUID id, Person person);

    boolean deletePersonById(UUID id);


}
