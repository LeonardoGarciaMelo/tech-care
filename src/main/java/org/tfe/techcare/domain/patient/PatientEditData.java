package org.tfe.techcare.domain.patient;

import org.tfe.techcare.domain.address.Address;

public record PatientEditData(

        Long id,

        int age,

        String phone,

        String email,

        Address address,

        String diagnosis

) {}
