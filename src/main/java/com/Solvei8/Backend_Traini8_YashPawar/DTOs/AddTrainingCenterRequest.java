package com.Solvei8.Backend_Traini8_YashPawar.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class AddTrainingCenterRequest {

    @NotNull(message = "Center Name is required")
    @Size(max = 40, message = "Center Name must be less than 40 characters")
    private String centerName;

    @NotNull(message = "Center Code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @NotNull(message = "Address is required")
    @Valid
    private AddressDTO address;

    @NotNull(message = "Student Capacity is required")
    private int studentCapacity;

    private List<String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must a 10 digit number")
    private String contactPhone;
}

