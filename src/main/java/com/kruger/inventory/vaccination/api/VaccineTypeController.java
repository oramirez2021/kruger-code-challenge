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
    private final VaccineTypeService vaccineTypeService;

    /**
     * This endpoint will create a new Vaccine type in DB
     * @param vaccineType gets the Vaccine Entity to deserialize
     * @return a Vaccine type entity
     */
    @PostMapping("/vaccinetype")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<VaccineType> createVaccineType(@RequestBody @Valid VaccineType vaccineType){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/vaccinetype").toUriString());
        return ResponseEntity.created(uri).body(vaccineTypeService.createVaccineType(vaccineType));
    }

    /**
     * This endpoint will update the specific data to Vaccine type entity
     * @param vaccineType receive the Vaccine type entity from request
     * @return a Vaccine Type entity
     */
    @PutMapping("/vaccinetype")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows a certain type of Vaccine by the code of Vaccine"
    )
    public ResponseEntity<VaccineType> updateVaccineType(@RequestBody @Valid VaccineType vaccineType){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/vaccinetype").toUriString());
        return ResponseEntity.created(uri).body(vaccineTypeService.updateVaccineType(vaccineType));
    }

    /**
     * This endopoint allows us to eliminate a certain Vaccine Type
     * @param codType the id of the Vaccine type to eliminate
     * @return a Vaccine type entity
     */
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

    /**
     * this endpoint lists the Vaccine types that are recorded in the gross system
     * @return a list of Vaccine type Entity
     */
    @GetMapping("/listVaccineTypes")
    @Operation(
            tags ="Vaccine Controllers",
            description = "Shows all the Types of Vaccines those the Company handle"
    )
    public ResponseEntity<List<VaccineType>> getVaccineTypes(){
        return ResponseEntity.ok().body(vaccineTypeService.obtainListVaccineTypes());
    }
}
