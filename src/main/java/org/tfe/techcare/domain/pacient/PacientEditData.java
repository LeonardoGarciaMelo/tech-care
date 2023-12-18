package org.tfe.techcare.domain.pacient;

import org.tfe.techcare.domain.address.Address;

public record PacientEditData(

        Long id,

        int age,

        String phone,

        String email,

        Address address,

        String diagnosis

) {}
