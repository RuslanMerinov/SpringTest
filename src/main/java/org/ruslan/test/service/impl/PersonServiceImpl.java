package org.ruslan.test.service.impl;

import org.ruslan.test.dao.PersonDao;
import org.ruslan.test.dao.UserNotFoundException;
import org.ruslan.test.dao.model.Person;
import org.ruslan.test.service.model.PersonDTO;
import org.ruslan.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }


    @Override
    public int addPerson(PersonDTO personDTO) {
        return personDao.insertPerson(convertDTO(personDTO));
    }

    @Override
    public List<Person> showList() {
        return personDao.showList();
    }

    @Override
    public Optional<Person> selectPersonById (UUID id) {
        return personDao.selectPersonById(id);
    }

    @Override
    public boolean deletePersonById (UUID id) throws UserNotFoundException {
        return personDao.deletePersonById(id);
    }

    @Override
    public boolean updatePersonById (UUID id, PersonDTO personDTO) {
        return personDao.updatePersonById(id, convertDTO(personDTO));
    }

    private Person convertDTO (PersonDTO personDTO) {
        return new Person(null, personDTO.getName() + " converted");
    }

}
