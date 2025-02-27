package com.Solvei8.Backend_Traini8_YashPawar.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class AddressDTO {

    @NotNull(message = "Detailed Address is required")
    private String detailedAddress;

    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotNull(message = "Pin code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pin code must be a 6-digit number")
    private String pincode;

    public AddressDTO(String detailedAddress, String city, String state, String pincode) {
        this.detailedAddress = detailedAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
