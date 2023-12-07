package org.tfe.techcare.domain.pacient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.gender.Gender;

@Table(name = "pacients")
@Entity(name = "Pacient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String phone;
    private String email;
    private Address address;
    private String diagnosis;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
