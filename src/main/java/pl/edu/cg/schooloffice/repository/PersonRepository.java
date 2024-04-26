package pl.edu.cg.schooloffice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.cg.schooloffice.entity.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    List<Person> findByFirstName(String firstName);

}
