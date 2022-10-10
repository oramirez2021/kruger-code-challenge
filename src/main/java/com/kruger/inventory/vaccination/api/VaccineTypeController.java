package com.kruger.inventory.vaccination.api;

import com.kruger.inventory.vaccination.model.VaccineType;
import com.kruger.inventory.vaccination.service.VaccineTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor @Slf4j
public class VaccineTypeController {
    /** CRUD
     * PUT to insert a row into the model
     * DELETE to eliminate a row from the model
     * UPDATE to update a row of the model
     * **/
    private final VaccineTypeService vaccineTypeService;
    @PostMapping("/vaccinetype")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<VaccineType> createVaccineType(@RequestBody @Valid VaccineType vaccineType){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/vaccinetype").toUriString());
        return ResponseEntity.created(uri).body(vaccineTypeService.createVaccineType(vaccineType));
    }
    @PutMapping("/vaccinetype")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<VaccineType> updateVaccineType(@RequestBody @Valid VaccineType vaccineType){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/vaccinetype").toUriString());
        return ResponseEntity.created(uri).body(vaccineTypeService.updateVaccineType(vaccineType));
    }
    @DeleteMapping("/vaccinetype")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<VaccineType> eliminateVaccineType(@RequestParam int codType){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/vaccinetype").toUriString());
        VaccineType vaccineType = vaccineTypeService.obtainVaccineType(codType);
        vaccineTypeService.deleteVaccineType(codType);
        return ResponseEntity.created(uri).body(vaccineType);
    }

    @GetMapping("/listVaccineTypes")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows all the Types of Vaccines those the Company handle"
    )
    public ResponseEntity<List<VaccineType>> getVaccineTypes(){
        return ResponseEntity.ok().body(vaccineTypeService.obtainListVaccineTypes());
    }
}
