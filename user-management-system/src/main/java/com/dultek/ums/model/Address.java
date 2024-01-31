package com.dultek.ums.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 255, message = "Street must be less than 255 characters")
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must be less than 100 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State must be less than 100 characters")
    private String state;

    @NotBlank(message = "Zip Code is required")
    @Size(max = 20, message = "Zip Code must be less than 20 characters")
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", unique = true)
    private User user;

}

