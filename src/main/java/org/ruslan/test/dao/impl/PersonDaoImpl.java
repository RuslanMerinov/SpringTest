package org.ruslan.test.dao.impl;

import org.ruslan.test.dao.PersonDao;
import org.ruslan.test.dao.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final List<Person> DB = new ArrayList<>();

    @Override
    public boolean addPerson(Person person) {
        return DB.add(new Person(UUID.randomUUID(), person.getName()));
    }

    @Override
    public List<Person> getList() {
        return DB;
    }

    private Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> update(id, person, p))
                .isPresent();
    }

    private boolean update (UUID id, Person person, Person p) {
        if (DB.indexOf(p) != -1) {
            DB.set(DB.indexOf(p), new Person(id, person.getName()));
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePersonById(UUID id) {
        if (selectPersonById(id).isPresent()) {
            DB.remove(selectPersonById(id).get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Person> selectNewPersonById(UUID id) {
        return DB.stream()
                .filter(p-> p.getId().equals(id))
                .collect(Collectors.toList());
    }

}
