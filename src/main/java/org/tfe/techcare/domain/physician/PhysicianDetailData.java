package org.tfe.techcare.domain.physician;

import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.specialization.Specialization;

public record PhysicianDetailData(
        Long id,

        String name,

        int age,

        String phone,

        String email,

        Address address,

        String registrationNumber,

        Specialization specialization
) {
    public PhysicianDetailData(Physician physician) {
        this(physician.getId(), physician.getName(), physician.getAge(), physician.getPhone(),
        physician.getEmail(), physician.getAddress(), physician.getRegistrationNumber(), physician.getSpecialization());
    }
}
