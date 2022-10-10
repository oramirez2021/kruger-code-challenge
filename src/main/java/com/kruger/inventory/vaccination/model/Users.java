package com.kruger.inventory.vaccination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Users {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name = "userName", nullable = false, length = 50)
    @NotBlank(message = "User name field is mandatory")
    private String userName;
    @Column(name = "password", nullable = false, length = 50)
    @NotBlank(message = "Password name field is mandatory")
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
