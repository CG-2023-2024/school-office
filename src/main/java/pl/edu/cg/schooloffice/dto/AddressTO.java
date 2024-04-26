package pl.edu.cg.schooloffice.dto;

import pl.edu.cg.schooloffice.entity.AddressType;

public record AddressTO(
        String street,
        String houseNumber,
        Integer flatNumber,
        String postalCode,
        String city,
        String country,
        AddressType addressType) {
}
