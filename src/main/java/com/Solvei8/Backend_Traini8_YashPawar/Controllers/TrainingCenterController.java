package com.Solvei8.Backend_Traini8_YashPawar.Controllers;

import com.Solvei8.Backend_Traini8_YashPawar.DTOs.AddTrainingCenterRequest;
import com.Solvei8.Backend_Traini8_YashPawar.DTOs.TrainingCenterResponse;
import com.Solvei8.Backend_Traini8_YashPawar.Services.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainingcenter")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("add")
    public ResponseEntity<TrainingCenterResponse> addTrainingCenter(@RequestBody @Valid AddTrainingCenterRequest addTrainingCenterRequest) {
        TrainingCenterResponse response = trainingCenterService.addTrainingCenter(addTrainingCenterRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TrainingCenterResponse>> getAllTrainingCenters() {
        List<TrainingCenterResponse> response = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(response);
    }
}
