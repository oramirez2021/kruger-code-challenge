package com.kruger.inventory.vaccination.repository;

import com.kruger.inventory.vaccination.model.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineTypeRepo extends JpaRepository<VaccineType, Integer> {
    VaccineType findByCodType(int codTypeeeee);
}
