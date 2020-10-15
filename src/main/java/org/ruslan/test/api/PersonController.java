package org.ruslan.test.api;

import org.ruslan.test.dao.model.Person;
import org.ruslan.test.service.model.PersonDTO;
import org.ruslan.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public boolean addPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @GetMapping
    public List<Person> getList() {
        return personService.getList();
    }

//    @GetMapping(path = "/{id}")
//    public Person selectPersonById(@PathVariable("id") UUID id) {
//        Optional<Person> selected = personService.selectPersonById(id);
//        return selected.orElse(null);
//    }

    @GetMapping(path = "{id}")
    public List<Person> selectNewPersonById(@PathVariable("id") UUID id) {
        return personService.selectNewPersonById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "/{id}")
    public boolean updatePersonById(@PathVariable("id") UUID id, @RequestBody @Valid PersonDTO personDTO) {
        return personService.updatePersonById(id, personDTO);
    }

}
