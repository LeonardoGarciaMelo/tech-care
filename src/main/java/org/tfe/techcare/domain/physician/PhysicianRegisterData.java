package org.tfe.techcare.domain.physician;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.tfe.techcare.domain.address.AddressData;
import org.tfe.techcare.domain.specialization.Specialization;

public record PhysicianRegisterData(

        @NotBlank
        String name,

        @NotNull
        int age,

        @NotBlank
        String phone,
        
        @NotBlank
        @Email
        String email,
        
        @NotNull
        @Valid
        AddressData address,

        @NotBlank
        String registrationNumber,

        @NotNull
        Specialization specialization

) {}
