package com.kruger.inventory.vaccination.api;

import com.kruger.inventory.vaccination.model.Employee;
import com.kruger.inventory.vaccination.model.Users;
import com.kruger.inventory.vaccination.model.VaccineType;
import com.kruger.inventory.vaccination.service.EmployeeService;
import com.kruger.inventory.vaccination.service.UsersService;
import com.kruger.inventory.vaccination.useful.Generator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * This class allows us to implement the rest endpoints
 * that will be able to handle the CRUD and some filters needed
 */
@RestController @RequestMapping("/api") @RequiredArgsConstructor @Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;
    private final UsersService usersService;

    /**
     * This endpoint will create a new Employee
     * @param employee receive the employee object that will be deserialized
     * @return and Entity
     */
    @PostMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee){
        log.info("xxxxxx"+ employee);
        Users user = new Users();
        Generator generator = new Generator();
        String userName = generator.generateUsername(employee);
        String password = generator.generateRandomPassword(7);
        user.setUserName(userName);
        user.setPassword(password);
        log.info("USUARIO** "+userName);
        log.info("PASSWORD** "+password);
        usersService.createUser(user);
        log.info("IDDDDDDD "+usersService.obtainTheInsertedId(user));
        employee.setId(user);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        return ResponseEntity.created(uri).body(employeeService.createEmployee(employee));
    }
    /**
     * This endpoint will update de date of a certain Employee
     * @param employee receive the employee object with the needed data to update that will be deserialized
     * @return and Entity
     */
    @PutMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid  Employee employee){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        return ResponseEntity.created(uri).body(employeeService.updateEmployee(employee));
    }

    /**
     * This endpoint allows us to eliminate a certain Employee by the identification
     * @param identification the identification of the Employee to eliminate
     * @return and Entity
     */
    @DeleteMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> eliminateEmployee(@RequestParam String identification){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        Employee employee = employeeService.obtainEmployeeByIdentification(identification);
        employeeService.deleteEmployee(identification);
        return ResponseEntity.created(uri).body(employee);
    }

    /**
     * This endpoint list in json format the list of Employees by the Vaccination state (SI/NO)
     * @param vaccState  the state to look for
     * @return and List of Employees
     */
    @Operation(
            tags ="Employee Controllers",
           description = "Shows up a list of Employees those got or not the shot"
    )
    public ResponseEntity<List<Employee>> getEmployeesByVaccState(String vaccState){
        return ResponseEntity.ok().body(employeeService.obtainListByVaccinationState(vaccState));
    }

    /**
     * This endpoint lists the Employees by the Vaccine brand of type
     * @param codType the Vaccine brand code
     * @return a list of Employees
     */
    @GetMapping("/listEmployeeByCodType")
    @Operation(
            tags ="Employee Controllers",
            description = "Shows up all the Employees filtered by Vaccine Type. eg. Astrazeneca"
    )
    public ResponseEntity<List<Employee>> getEmployeesByCodType(VaccineType codType){
        return ResponseEntity.ok().body(employeeService.obtainListByVaccineType(codType));
    }

    /**
     * this endpoint lists the Employees that were vaccinated in a certain range of dates
     * @param fecIni the init date
     * @param fecFin the end date
     * @return a list of Employees
     */
    @GetMapping("/listEmployeeByVaccDateRange")
    @Operation(
            tags ="Employee Controllers",
            description = "Show up all the Employees in a certain range of dates"
    )
    public ResponseEntity<List<Employee>> getEmployeesByVaccDateRange(String fecIni, String fecFin){
        return ResponseEntity.ok().body(employeeService.obtainListByDateRange(LocalDate.parse(fecIni), LocalDate.parse(fecFin)));
    }
}
