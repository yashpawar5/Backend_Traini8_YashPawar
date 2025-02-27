package com.solvei8.backend_traini8_yashpawar.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TrainingCenterResponse {
    private String centerName;
    private String centerCode;
    private AddressDTO address;  // Reusing AddressDTO for response
    private int studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;

    public TrainingCenterResponse(String centerName, String centerCode, AddressDTO address,
                                  int studentCapacity, List<String> coursesOffered,
                                  String contactEmail, String contactPhone) {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.address = address;
        this.studentCapacity = studentCapacity;
        this.coursesOffered = coursesOffered;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
}
