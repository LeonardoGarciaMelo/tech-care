package org.tfe.techcare.domain.patient;

import org.tfe.techcare.domain.gender.Gender;

public record PatientListData(
        Long id,
        String name,
        int age,
        String diagnosis,
        Gender gender
) {
    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getAge(), patient.getDiagnosis(), patient.getGender());
    }
}
