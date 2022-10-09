package com.kruger.inventory.vaccination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineType {
    @Id @GeneratedValue(strategy = AUTO)
    protected int codType;
    @Column(name = "typDes", nullable = false, length = 50)
    @NotBlank(message = "Brand of Vaccine field is mandatory")
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$", message = "Vaccine's brand must contains just letters")
    private String typDes;
    @Column(name = "typSta", nullable = false, length = 2)
    @NotBlank(message = "Status of vaccine field is mandatory")
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$", message = "Status of vaccine must contains just letters")
    private String typSta;
}
