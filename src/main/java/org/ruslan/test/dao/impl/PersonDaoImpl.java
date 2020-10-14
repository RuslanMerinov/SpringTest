package org.ruslan.test.dao.impl;

import org.ruslan.test.dao.PersonDao;
import org.ruslan.test.dao.UserNotFoundException;
import org.ruslan.test.dao.model.Person;
import org.ruslan.test.service.model.PersonDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(Person person) {
        DB.add(new Person(UUID.randomUUID(), person.getName()));
        return 0;
    }

    @Override
    public List<Person> showList() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToDelete = DB.indexOf(p);
            if (indexOfPersonToDelete >= 0) {
                DB.set(indexOfPersonToDelete, new Person(id, person.getName()));
                return true;
            }
            return false;
        })
                .orElse(false);
    }

    @Override
    public boolean deletePersonById(UUID id) throws UserNotFoundException {

        Optional<Person> personMaybe = Optional.of(selectPersonById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString())));
        DB.remove(personMaybe.get());
        return true;



    }

}
