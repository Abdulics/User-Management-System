package com.dultek.ums.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Validator validator;

    public EmployeeTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidEmployee() {
        Employee validEmployee = new Employee(/* Initialize a valid employee here */);

        Set<ConstraintViolation<Employee>> violations = validator.validate(validEmployee);

        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalidEmployee() {
        Employee invalidEmployee = new Employee(/* Initialize an invalid employee here */);

        Set<ConstraintViolation<Employee>> violations = validator.validate(invalidEmployee);

        // Assert that there are violations based on the validation annotations in your Employee class
        // Example: assertEquals(1, violations.size());
    }
}