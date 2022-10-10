package com.kruger.inventory.vaccination.service;

import com.kruger.inventory.vaccination.custom.exception.IdentificationEmployeeAlreadyExistsException;
import com.kruger.inventory.vaccination.model.Employee;
import com.kruger.inventory.vaccination.model.VaccineType;
import com.kruger.inventory.vaccination.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * This class will implement the functionality from the EmployeeService Interface
 */
@Slf4j @AllArgsConstructor @Service @Transactional
public class EmployeeServiceImp  implements EmployeeService{
    private final EmployeeRepo employeeRepo;
    @Override
    public List<Employee> obtainListByVaccinationState(String vacState) {
        log.info("Looking for Employees their vaccination state");
        return employeeRepo.findByVacState(vacState);
    }

    @Override
    public List<Employee> obtainListByVaccineType(VaccineType codType) {
        log.info("Looking for Employees their vaccination type");
        return employeeRepo.findByCodType(codType);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeRes = employeeRepo.save(employee);
        return employeeRes;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee obtainEmployeeByIdentification(String identification) {
        Employee employee = employeeRepo.findByIdentification(identification);
        return employee;
    }

    @Override
    public void deleteEmployee(String identification) {
        Employee employee = employeeRepo.findByIdentification(identification);
        log.info("Eliminating Employee with name {}, ",employee.getNames());
        employeeRepo.deleteByIdentification(identification);
    }

    @Override
    public List<Employee> obtainListByDateRange(LocalDate fecIni, LocalDate fecFin) {
        log.info("Looking for Employees their vacctination date is between {} and {}",fecIni,fecFin);
        return employeeRepo.getAllBetweenDatesVacc(fecIni,fecFin);
    }
}
