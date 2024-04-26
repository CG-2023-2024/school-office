package pl.edu.cg.schooloffice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.cg.schooloffice.dto.PersonTO;
import pl.edu.cg.schooloffice.mapper.PersonTOMapper;
import pl.edu.cg.schooloffice.repository.AddressRepository;
import pl.edu.cg.schooloffice.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    private final AddressRepository addressRepository;

    private final PersonTOMapper mapper;

    public Long save(PersonTO personTO) {
        log.info(personTO.toString());
        var person = mapper.map(personTO);
        addressRepository.saveAll(person.getAddresses());
        return repository.save(person).getId();
    }

    public List<PersonTO> getPersons() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    public Optional<PersonTO> findById(Long id) {
        return repository.findById(id).map(mapper::map);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<PersonTO> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName).stream().map(mapper::map).collect(Collectors.toList());
    }
}
