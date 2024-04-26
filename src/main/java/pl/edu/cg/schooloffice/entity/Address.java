package pl.edu.cg.schooloffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String houseNumber;

    private Integer flatNumber;

    private String postalCode;

    private String city;

    private String country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
