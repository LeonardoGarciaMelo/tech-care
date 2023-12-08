package org.tfe.techcare.domain.address;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;

    private String state;

    private String postalCode;

    public Address(AddressData data) {
        this.city = data.city();
        this.state = data.state();
        this.postalCode = data.postalCode();
    }
}
