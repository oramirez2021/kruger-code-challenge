package com.kruger.inventory.vaccination.api;

import com.kruger.inventory.vaccination.model.Employee;
import com.kruger.inventory.vaccination.model.Users;
import com.kruger.inventory.vaccination.model.VaccineType;
import com.kruger.inventory.vaccination.service.EmployeeService;
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

@RestController @RequestMapping("/api") @RequiredArgsConstructor @Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee){
        Users user = new Users();
        Generator generator = new Generator();
        String userName = generator.generateUsername(employee);
        String password = generator.generateRandomPassword(7);
        user.setUserName(userName);
        user.setPassword(password);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        return ResponseEntity.created(uri).body(employeeService.createEmployee(employee));
    }
    @PutMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        return ResponseEntity.created(uri).body(employeeService.updateEmployee(employee));
    }
    @DeleteMapping("/employee")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<Employee> eliminateEmployee(@RequestParam Long identificacion){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/employee").toUriString());
        Employee employee = employeeService.obtainEmployeeByIdentification(identificacion);
        employeeService.deleteEmployee(identificacion);
        return ResponseEntity.created(uri).body(employee);
    }
   @Operation(
            tags ="Employee Controllers",
           description = "Shows up a list of Employees those got or not the shot"
    )
    public ResponseEntity<List<Employee>> getEmployeesByVaccState(String vaccState){
        return ResponseEntity.ok().body(employeeService.obtainListByVaccinationState(vaccState));
    }

    @GetMapping("/listEmployeeByCodType")
    @Operation(
            tags ="Employee Controllers",
            description = "Shows up all the Employees filtered by Vaccine Type. eg. Astrazeneca"
    )
    public ResponseEntity<List<Employee>> getEmployeesByCodType(VaccineType codType){
        return ResponseEntity.ok().body(employeeService.obtainListByVaccineType(codType));
    }

    @GetMapping("/listEmployeeByVaccDateRange")
    @Operation(
            tags ="Employee Controllers",
            description = "Show up all the Employees in a certain range of dates"
    )
    public ResponseEntity<List<Employee>> getEmployeesByVaccDateRange(String fecIni, String fecFin){
        return ResponseEntity.ok().body(employeeService.obtainListByDateRange(LocalDate.parse(fecIni), LocalDate.parse(fecFin)));
    }
}
