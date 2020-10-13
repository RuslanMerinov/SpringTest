package org.ruslan.test.api;

import org.ruslan.test.service.model.PersonDTO;
import org.ruslan.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
// hello from git
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody @Valid PersonDTO personDTO) {
        personService.addPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> showList() {
        return personService.showList();
    }

    @GetMapping(path = "/{id}")
    public PersonDTO selectPersonById(@PathVariable("id") UUID id) {
        return personService.selectPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }

    @PutMapping(path = "/{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody @Valid PersonDTO personDTO) {
        return personService.updatePersonById(id, personDTO);
    }

}
