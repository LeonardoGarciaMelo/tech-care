package org.tfe.techcare.domain.pacient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.tfe.techcare.domain.address.AddressData;
import org.tfe.techcare.domain.gender.Gender;

public record PacientRegisterData(

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

        @NotNull
        String diagnosis,

        @NotNull
        Gender gender
) {}
