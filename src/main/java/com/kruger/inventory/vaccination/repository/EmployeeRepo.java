package com.kruger.inventory.vaccination.repository;

import com.kruger.inventory.vaccination.model.Employee;
import com.kruger.inventory.vaccination.model.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    void deleteByIdentification(String identification);
    Employee findByIdentification(String identification);

    List<Employee> findByVacState(String vacState);
    //@Query("select u from user u where upper(u.name) like upper(?1)")
    List<Employee> findByCodType(VaccineType codType);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE VAC_DATE between cast(:vaccDateIni as date) and cast(:vaccDateEnd as date)", nativeQuery = true)
    List<Employee> getAllBetweenDatesVacc(@Param("vaccDateIni") LocalDate vaccDateIni, @Param("vaccDateEnd") LocalDate vaccDateEnd);
}
