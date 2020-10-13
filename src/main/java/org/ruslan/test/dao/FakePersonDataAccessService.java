package org.ruslan.test.dao;

import org.ruslan.test.service.model.PersonDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakePersonDataAccessService implements PersonDao {

    private final List<PersonDTO> DB = new ArrayList<>();

    @Override
    public int insertPerson(PersonDTO personDTO) {
        UUID id = UUID.randomUUID();
        DB.add(new PersonDTO(id, personDTO.getName()));
        return 0;
    }

    @Override
    public List<PersonDTO> showList() {
        return DB;
    }

    @Override
    public Optional<PersonDTO> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePersonById(UUID id, PersonDTO personDTO) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToDelete = DB.indexOf(p);
            if (indexOfPersonToDelete >= 0) {
                DB.set(indexOfPersonToDelete, new PersonDTO(id, personDTO.getName()));
                return 1;
            }
            return 0;
        })
                .orElse(0);
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<PersonDTO> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()){ return 0;}
        DB.remove(personMaybe.get());
        return 1;
    }

}
