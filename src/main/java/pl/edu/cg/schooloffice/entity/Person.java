package pl.edu.cg.schooloffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String secondName;

    private LocalDate birthDate;

    @OneToMany
    private List<Address> addresses;

}
