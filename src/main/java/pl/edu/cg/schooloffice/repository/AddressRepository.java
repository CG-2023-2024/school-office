package pl.edu.cg.schooloffice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.cg.schooloffice.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
