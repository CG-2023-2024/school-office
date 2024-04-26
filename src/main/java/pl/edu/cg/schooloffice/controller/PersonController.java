package pl.edu.cg.schooloffice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.cg.schooloffice.dto.PersonTO;
import pl.edu.cg.schooloffice.service.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
@CrossOrigin(origins = "${CROSS-ORIGIN:*}")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody PersonTO personTO) {
        var id = personService.save(personTO);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public void update(@RequestBody PersonTO personTO) {
        personService.save(personTO);
    }

    @GetMapping
    public List<PersonTO> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "/search")
    public List<PersonTO> findByFirstName(@RequestParam String firstName) {
        return personService.findByFirstName(firstName);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonTO> findById(@PathVariable("id") Long id) {
        return personService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }

}
