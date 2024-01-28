package com.dultek.ums.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {


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

}

