package com.Solvei8.Backend_Traini8_YashPawar.services;

import com.Solvei8.Backend_Traini8_YashPawar.models.Address;
import com.Solvei8.Backend_Traini8_YashPawar.models.TrainingCenter;
import com.Solvei8.Backend_Traini8_YashPawar.repositories.AddressRepository;
import com.Solvei8.Backend_Traini8_YashPawar.repositories.TrainingCenterRepository;
import com.Solvei8.Backend_Traini8_YashPawar.dtos.AddTrainingCenterRequest;
import com.Solvei8.Backend_Traini8_YashPawar.dtos.AddressDTO;
import com.Solvei8.Backend_Traini8_YashPawar.dtos.TrainingCenterResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing training centers.
 * This class handles business logic related to training centers,
 * including adding new centers and retrieving stored centers.
 */
@Service
public class TrainingCenterService {

    private final AddressRepository addressRepository;
    private final TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterService(AddressRepository addressRepository, TrainingCenterRepository trainingCenterRepository) {
        this.addressRepository = addressRepository;
        this.trainingCenterRepository = trainingCenterRepository;
    }

    /**
     * Adds a new training center to the database.
     *
     * @param trainingCenterRequest The request containing training center details.
     * @return The response containing the saved training center details.
     */
    @Transactional
    public TrainingCenterResponse addTrainingCenter(AddTrainingCenterRequest trainingCenterRequest) {
        Address address = saveAddress(trainingCenterRequest);
        TrainingCenter trainingCenter = saveTrainingCenter(trainingCenterRequest, address);
        return convertToResponse(trainingCenter);
    }

    /**
     * Retrieves all training centers stored in the database.
     *
     * @return A list of {@link TrainingCenterResponse} objects representing the training centers.
     */
    public List<TrainingCenterResponse> getAllTrainingCenters() {
        return trainingCenterRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Saves the address of a training center in the database.
     *
     * @param trainingCenterRequest The request containing address details.
     * @return The saved Address entity.
     */
    @Transactional
    protected Address saveAddress(AddTrainingCenterRequest trainingCenterRequest) {
        return addressRepository.save(
                Address.builder()
                        .detailedAddress(trainingCenterRequest.getAddress().getDetailedAddress())
                        .city(trainingCenterRequest.getAddress().getCity())
                        .state(trainingCenterRequest.getAddress().getState())
                        .pincode(trainingCenterRequest.getAddress().getPincode())
                        .build()
        );
    }

    /**
     * Saves the training center details in the database.
     *
     * @param trainingCenterRequest The request containing training center details.
     * @param address The associated address entity.
     * @return The saved TrainingCenter entity.
     */
    @Transactional
    protected TrainingCenter saveTrainingCenter(AddTrainingCenterRequest trainingCenterRequest, Address address) {
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

    /**
     * Converts a {@link TrainingCenter} entity to a {@link TrainingCenterResponse} DTO.
     *
     * @param trainingCenter The TrainingCenter entity.
     * @return A TrainingCenterResponse DTO representing the training center.
     */
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
