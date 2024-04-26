package pl.edu.cg.schooloffice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.edu.cg.schooloffice.dto.PersonTO;

@Slf4j
@Component
public class PersonListener {

    //@JmsListener(id = "_Person", destination = "person.queue")
    public void receivePerson(PersonTO personTO) {
        log.info("Otrzymałem: " + personTO);
    }
}
