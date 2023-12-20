package org.tfe.techcare.domain.patient;

import org.tfe.techcare.domain.address.Address;
import org.tfe.techcare.domain.gender.Gender;

public record PatientDetailData(

        Long id,
        String name,
        int age,
        String phone,
        String email,
        Address address,
        String diagnosis,
        Gender gender
) {
    public PatientDetailData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getAge(), patient.getPhone(), patient.getEmail(),
                patient.getAddress(), patient.getDiagnosis(), patient.getGender());
    }
}
