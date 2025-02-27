package com.solvei8.backend_traini8_yashpawar.controllers;

import com.solvei8.backend_traini8_yashpawar.dtos.AddTrainingCenterRequest;
import com.solvei8.backend_traini8_yashpawar.dtos.TrainingCenterResponse;
import com.solvei8.backend_traini8_yashpawar.services.TrainingCenterService;
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
