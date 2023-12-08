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
    private Long id;
    private String name;
    private int age;
    private String phone;
    private String email;
    private Address address;
    private String diagnosis;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Pacient(PacientRegisterData data) {
        this.name = data.name();
        this.age = data.age();
        this.phone = data.phone();
        this.email = data.email();
        this.address = new Address(data.address());
        this.diagnosis = data.diagnosis();
        this.gender = data.gender();
    }
}
