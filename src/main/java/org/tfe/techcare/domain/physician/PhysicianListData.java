package org.tfe.techcare.domain.physician;

import org.tfe.techcare.domain.specialization.Specialization;

public record PhysicianListData(

        Long id,

        String name,

        String phone,

        String registrationNumber,

        Specialization specialization

) {
    public PhysicianListData(Physician physician) {
        this(physician.getId(), physician.getName(), physician.getPhone(), physician.getRegistrationNumber(), physician.getSpecialization());
    }
}