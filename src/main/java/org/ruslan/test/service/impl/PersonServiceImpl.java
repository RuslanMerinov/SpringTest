package org.ruslan.test.service.impl;

import org.ruslan.test.dao.PersonDao;
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
        //convert ->personDTO to person
        return personDao.insertPerson(personDTO);
    }

    @Override
    public List<PersonDTO> showList() {
        return personDao.showList();
    }

    @Override
    public Optional<PersonDTO> selectPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    @Override
    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }

    @Override
    public int updatePersonById(UUID id, PersonDTO personDTO) {
        return personDao.updatePersonById(id, personDTO);
    }

}
