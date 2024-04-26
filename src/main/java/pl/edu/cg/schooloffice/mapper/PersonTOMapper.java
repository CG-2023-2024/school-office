package pl.edu.cg.schooloffice.mapper;

import org.mapstruct.Mapper;
import pl.edu.cg.schooloffice.dto.PersonTO;
import pl.edu.cg.schooloffice.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonTOMapper {

    Person map(PersonTO personTO);

    PersonTO map(Person person);

}
