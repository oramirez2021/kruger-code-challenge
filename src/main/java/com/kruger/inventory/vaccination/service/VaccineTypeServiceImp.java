package com.kruger.inventory.vaccination.service;

import com.kruger.inventory.vaccination.model.VaccineType;
import com.kruger.inventory.vaccination.repository.VaccineTypeRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * This class will implement the functionality from the VaccineTypeService Interface
 */
@RequiredArgsConstructor @Service @Transactional @Slf4j
public class VaccineTypeServiceImp implements VaccineTypeService{
    private final VaccineTypeRepo vaccineTypeRepo;

    @Override
    public VaccineType updateVaccineType(VaccineType vaccineType) {
        return vaccineTypeRepo.save(vaccineType);
    }

    @Override
    public List<VaccineType> obtainListVaccineTypes() {
        log.info("Obtaining Vaccine Types list...");
        return vaccineTypeRepo.findAll();
    }

    @Override
    public VaccineType createVaccineType(VaccineType vaccineType) {
        return vaccineTypeRepo.save(vaccineType);
    }

    @Override
    public VaccineType obtainVaccineType(int cod_type) {

        return null;
    }

    @Override
    public void deleteVaccineType(int cod_type) {
        VaccineType vaccineType = vaccineTypeRepo.findByCodType(cod_type);
        log.info("Eliminating Vaccine type {}, ",vaccineType.getTypDes());
        vaccineTypeRepo.delete(vaccineType);
    }
}
