package org.tfe.techcare.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String postalCode
) {}
