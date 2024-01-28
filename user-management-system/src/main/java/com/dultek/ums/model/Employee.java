package com.dultek.ums.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Ensure equals and hashcode consider superclass fields
@NoArgsConstructor
public class Employee extends User {

    // Adjusted constructor without including id and version
    public Employee(String employeeId, String firstName, String lastName,
                    String email, Address address, String ssn, UserCredentials credentials) {
        super(null, employeeId, null, firstName, lastName, email, address, ssn, credentials);
    }

    // Other fields, getters, and setters...
}
