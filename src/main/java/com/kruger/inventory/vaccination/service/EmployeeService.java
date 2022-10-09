package com.kruger.inventory.vaccination.service;

import com.kruger.inventory.vaccination.model.Employee;
import com.kruger.inventory.vaccination.model.VaccineType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long identification);
    Employee obtainEmployeeByIdentification(Long identification);
    List<Employee> obtainListByVaccinationState(String vaccState);
    List<Employee> obtainListByVaccineType(VaccineType codType);
    List<Employee> obtainListByDateRange(LocalDate fecIni, LocalDate fecFin);
}
