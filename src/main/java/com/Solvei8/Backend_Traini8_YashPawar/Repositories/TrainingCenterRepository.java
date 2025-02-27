package com.Solvei8.Backend_Traini8_YashPawar.Repositories;

import com.Solvei8.Backend_Traini8_YashPawar.Models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations on the {@link TrainingCenter} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction.
 */
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
