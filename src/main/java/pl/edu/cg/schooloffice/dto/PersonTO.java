package pl.edu.cg.schooloffice.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record PersonTO(
        Long id,
        String firstName,
        String secondName,
        LocalDate birthDate,
        List<AddressTO> addresses) implements Serializable {
}
