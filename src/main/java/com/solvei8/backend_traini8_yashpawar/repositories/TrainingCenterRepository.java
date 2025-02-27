package com.solvei8.backend_traini8_yashpawar.repositories;

import com.solvei8.backend_traini8_yashpawar.models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations on the {@link TrainingCenter} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction.
 */
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
