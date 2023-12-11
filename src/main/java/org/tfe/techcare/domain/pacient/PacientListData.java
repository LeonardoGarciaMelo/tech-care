package org.tfe.techcare.domain.pacient;

import org.tfe.techcare.domain.gender.Gender;

public record PacientListData(
        Long id,
        String name,
        int age,
        String diagnosis,
        Gender gender
) {
    public PacientListData(Pacient pacient) {
        this(pacient.getId(), pacient.getName(), pacient.getAge(), pacient.getDiagnosis(), pacient.getGender());
    }
}
