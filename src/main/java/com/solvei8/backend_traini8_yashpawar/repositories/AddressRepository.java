package com.solvei8.backend_traini8_yashpawar.repositories;

import com.solvei8.backend_traini8_yashpawar.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations on the {@link Address} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
