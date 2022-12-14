package com.kruger.inventory.vaccination.service;

import com.kruger.inventory.vaccination.model.VaccineType;

import java.util.List;
/**
 * This class sets the functionality the class will have
 */
public interface VaccineTypeService {
    VaccineType createVaccineType(VaccineType vaccineType);
    VaccineType updateVaccineType(VaccineType vaccineType);
    VaccineType obtainVaccineType(int cod_type);
    List<VaccineType> obtainListVaccineTypes();
    void deleteVaccineType(int cod_type);
}
