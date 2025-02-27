package com.Solvei8.Backend_Traini8_YashPawar.Services;

import com.Solvei8.Backend_Traini8_YashPawar.Models.Address;
import com.Solvei8.Backend_Traini8_YashPawar.Models.TrainingCenter;
import com.Solvei8.Backend_Traini8_YashPawar.Repositories.AddressRepository;
import com.Solvei8.Backend_Traini8_YashPawar.Repositories.TrainingCenterRepository;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.AddTrainingCenterRequest;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.AddressDTO;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.TrainingCenterResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    private final AddressRepository addressRepository;
    private final TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterService(AddressRepository addressRepository, TrainingCenterRepository trainingCenterRepository) {
        this.addressRepository = addressRepository;
        this.trainingCenterRepository = trainingCenterRepository;
    }

    public TrainingCenterResponse addTrainingCenter(AddTrainingCenterRequest trainingCenterRequest) {
        Address address = saveAddress(trainingCenterRequest);
        TrainingCenter trainingCenter = saveTrainingCenter(trainingCenterRequest, address);
        return convertToResponse(trainingCenter);
    }

    public List<TrainingCenterResponse> getAllTrainingCenters() {
        return trainingCenterRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private Address saveAddress(AddTrainingCenterRequest trainingCenterRequest) {
        return addressRepository.save(
                Address.builder()
                        .detailedAddress(trainingCenterRequest.getAddress().getDetailedAddress())
                        .city(trainingCenterRequest.getAddress().getCity())
                        .state(trainingCenterRequest.getAddress().getState())
                        .pincode(trainingCenterRequest.getAddress().getPincode())
                        .build()
        );
    }

    private TrainingCenter saveTrainingCenter(AddTrainingCenterRequest trainingCenterRequest, Address address) {
        return trainingCenterRepository.save(
                TrainingCenter.builder()
                        .centerName(trainingCenterRequest.getCenterName())
                        .centerCode(trainingCenterRequest.getCenterCode())
                        .address(address)
                        .studentCapacity(trainingCenterRequest.getStudentCapacity())
                        .coursesOffered(trainingCenterRequest.getCoursesOffered())
                        .contactEmail(trainingCenterRequest.getContactEmail())
                        .contactPhone(trainingCenterRequest.getContactPhone())
                        .build()
        );
    }

    private TrainingCenterResponse convertToResponse(TrainingCenter trainingCenter) {
        return new TrainingCenterResponse(
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
        );
    }
}
