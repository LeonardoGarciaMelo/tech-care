package org.tfe.techcare.domain.physician;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.specialization.Specialization;

@Table(name = "physicians")
@Entity(name = "Physician")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String phone;
    private String email;
    private Address address;
    private String registrationNumber;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    public Physician(PhysicianRegisterData data){
        this.name = data.name();
        this.age = data.age();
        this.phone = data.phone();
        this.email = data.email();
        this.address = new Address(data.address());
        this.registrationNumber = data.registrationNumber();
        this.specialization = data.specialization();
    }

    public void edit(PhysicianEditData editData) {
        if (editData.age() != 0) this.age = editData.age();
        if (editData.phone() != null) this.phone = editData.phone();
        if (editData.email() != null) this.email = editData.email();
        if (editData.address() != null) this.address = editData.address();
    }
}
