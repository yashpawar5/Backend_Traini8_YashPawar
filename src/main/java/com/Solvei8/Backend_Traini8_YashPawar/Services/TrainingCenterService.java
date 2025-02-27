package com.Solvei8.Backend_Traini8_YashPawar.Services;

import com.Solvei8.Backend_Traini8_YashPawar.Models.Address;
import com.Solvei8.Backend_Traini8_YashPawar.Models.TrainingCenter;
import com.Solvei8.Backend_Traini8_YashPawar.Repositories.AddressRepository;
import com.Solvei8.Backend_Traini8_YashPawar.Repositories.TrainingCenterRepository;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.AddTrainingCenterRequest;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.AddressDTO;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.TrainingCenterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterResponse addTrainingCenter(AddTrainingCenterRequest trainingCenterRequest) {
        Address address = Address.builder().detailedAddress(trainingCenterRequest.getAddress().getDetailedAddress())
                .city(trainingCenterRequest.getAddress().getCity())
                .state(trainingCenterRequest.getAddress().getState())
                .pincode(trainingCenterRequest.getAddress().getPincode())
                .build();
        address = addressRepository.save(address);

        TrainingCenter trainingCenter = TrainingCenter.builder().centerName(trainingCenterRequest.getCenterName())
                .centerCode(trainingCenterRequest.getCenterCode())
                .address(address)
                .studentCapacity(trainingCenterRequest.getStudentCapacity())
                .coursesOffered(trainingCenterRequest.getCoursesOffered())
                .contactEmail(trainingCenterRequest.getContactEmail())
                .contactPhone(trainingCenterRequest.getContactPhone())
                .build();

        trainingCenter = trainingCenterRepository.save(trainingCenter);

        AddressDTO addressDTO = new AddressDTO(
                trainingCenter.getAddress().getDetailedAddress(),
                trainingCenter.getAddress().getCity(),
                trainingCenter.getAddress().getState(),
                trainingCenter.getAddress().getPincode()
        );

        return new TrainingCenterResponse(trainingCenter.getCenterName(),
                trainingCenter.getCenterCode(),
                addressDTO,
                trainingCenter.getStudentCapacity(),
                trainingCenter.getCoursesOffered(),
                trainingCenter.getContactEmail(),
                trainingCenter.getContactPhone()
        );
    }

    public List<TrainingCenterResponse> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();
        return trainingCenters.stream().map(trainingCenter -> new TrainingCenterResponse(
                trainingCenter.getCenterName(),
                trainingCenter.getCenterCode(),
                new AddressDTO(
                        trainingCenter.getAddress().getDetailedAddress(),
                        trainingCenter.getAddress().getCity(),
                        trainingCenter.getAddress().getState(),
                        trainingCenter.getAddress().getPincode()
                ),
                trainingCenter.getStudentCapacity(),
                trainingCenter.getCoursesOffered(),
                trainingCenter.getContactEmail(),
                trainingCenter.getContactPhone()
        )).collect(Collectors.toList());
    }
}
