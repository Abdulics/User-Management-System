package com.dultek.ums.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(callSuper = true) // Ensure equals and hashcode consider superclass fields
@NoArgsConstructor
public class Employee extends User {

    // Adjusted constructor without including id and version
    public Employee(String employeeId, String firstName, String lastName,
                    String email, Address address, String ssn, UserCredentials credentials) {
        super(null, employeeId, null, firstName, lastName, email, address, ssn, credentials);
    }

    public Employee(String maimuna, String munaMuna, String mail) {
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
