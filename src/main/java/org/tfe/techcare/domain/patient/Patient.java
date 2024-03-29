package org.tfe.techcare.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.gender.Gender;

@Table(name = "patients") // A classe representa a tabela pacients
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
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

    public Patient(PatientRegisterData data) {
        this.name = data.name();
        this.age = data.age();
        this.phone = data.phone();
        this.email = data.email();
        this.address = new Address(data.address());
        this.diagnosis = data.diagnosis();
        this.gender = data.gender();
    }

    public void edit(PatientEditData editData) {
        if (editData.age() != 0) this.age = editData.age();
        if (editData.phone() != null) this.phone = editData.phone();
        if (editData.email() != null) this.email = editData.email();
        if (editData.address() != null) this.address = editData.address();
        if (editData.diagnosis() != null) this.diagnosis = editData.diagnosis();
    }
}
