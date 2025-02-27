package com.Solvei8.Backend_Traini8_YashPawar.repositories;

import com.Solvei8.Backend_Traini8_YashPawar.models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations on the {@link TrainingCenter} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction.
 */
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
