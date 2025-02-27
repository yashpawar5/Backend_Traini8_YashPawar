package com.Solvei8.Backend_Traini8_YashPawar.Repositories;

import com.Solvei8.Backend_Traini8_YashPawar.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations on the {@link Address} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
