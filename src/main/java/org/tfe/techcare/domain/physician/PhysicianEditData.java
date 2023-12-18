package org.tfe.techcare.domain.physician;

import org.tfe.techcare.domain.address.Address;

public record PhysicianEditData(

        Long id,

        int age,

        String phone,

        String email,

        Address address

) {}
