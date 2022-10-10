package com.kruger.inventory.vaccination.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
    @Id
    //private int idEmployee;
    @Column(name = "identification", nullable = false, length = 10, unique = true)
    @Pattern(regexp = "[0-9]{10,10}", message = "Identification must contains 10 numeric digits")
    @NotBlank(message = "Identification is mandatory")
    private String identification;
    @Column(name = "names", nullable = false, length = 50)
    @NotBlank(message = "Names field is mandatory")
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$", message = "Names must contains just letters")
    private String names;
    @Column(name = "sureNames", nullable = false, length = 50)
    @NotBlank(message = "sureNames field is mandatory")
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$", message = "sureNames must contains just letters")
    private String sureNames;
    @Column(name = "mail", nullable = false, length = 50)
    @Email(message = "Is not a valid email format")
    @NotBlank(message = "Email is mandatory")
    private String mail;
    @Column(name = "vacState", nullable = false)
    @NotBlank(message = "Vaccination state is mandatory")
    private String vacState;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Vaccination type is mandatory")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codType", referencedColumnName = "codType")
    private VaccineType codType;
    @Column(name = "vacDate", nullable = false)
    @NotNull(message = "Vaccination date is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate vacDate;
    @Column(name = "doseNumb", nullable = false)
    @NotBlank(message = "Number of doses is mandatory")
    @Pattern(regexp = "^[0-9]*$", message = "Identification must contains just numeric digicts")
    private String doseNumb;
    //@NotNull(message = "User's ID is mandatory")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Users id;
}
