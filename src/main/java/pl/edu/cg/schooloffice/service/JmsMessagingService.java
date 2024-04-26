package pl.edu.cg.schooloffice.service;

import jakarta.jms.Destination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pl.edu.cg.schooloffice.dto.PersonTO;

@Slf4j
@Service
public class JmsMessagingService {

    private final JmsTemplate jms;

    private final Destination queue;

    @Autowired
    public JmsMessagingService(JmsTemplate jms, @Qualifier("PERSON") Destination queue) {
        this.jms = jms;
        this.queue = queue;
    }

    public void sendOrder(PersonTO personTO) {
        jms.convertAndSend(queue, personTO);
    }


    public void receivePerson() {
        var person = (PersonTO) jms.receiveAndConvert(queue);
        log.info(person.toString());
    }

}
