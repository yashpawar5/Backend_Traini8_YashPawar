package com.Solvei8.Backend_Traini8_YashPawar.controllers;

import com.Solvei8.Backend_Traini8_YashPawar.dtos.AddTrainingCenterRequest;
import com.Solvei8.Backend_Traini8_YashPawar.dtos.TrainingCenterResponse;
import com.Solvei8.Backend_Traini8_YashPawar.services.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Training Centers.
 */

@RestController
@RequestMapping("trainingcenter")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    /**
     * Adds a training center to the Database.
     *
     * @return TrainingCenterResponse
     */
    @PostMapping("add")
    public ResponseEntity<TrainingCenterResponse> addTrainingCenter(@RequestBody @Valid AddTrainingCenterRequest addTrainingCenterRequest) {
        TrainingCenterResponse response = trainingCenterService.addTrainingCenter(addTrainingCenterRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves a list of all training centers.
     *
     * @return List of TrainingCenterResponse
     */
    @GetMapping("getAll")
    public ResponseEntity<List<TrainingCenterResponse>> getAllTrainingCenters() {
        List<TrainingCenterResponse> response = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(response);
    }
}
