package org.tfe.techcare.domain.pacient;

import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.gender.Gender;

public record PacientDetailData(

        Long id,
        String name,
        int age,
        String phone,
        String email,
        Address address,
        String diagnosis,
        Gender gender
) {
    public PacientDetailData(Pacient pacient){
        this(pacient.getId(), pacient.getName(), pacient.getAge(), pacient.getPhone(), pacient.getEmail(),
                pacient.getAddress(), pacient.getDiagnosis(), pacient.getGender());
    }
}
