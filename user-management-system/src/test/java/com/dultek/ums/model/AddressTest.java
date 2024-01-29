package com.dultek.ums.model;

import jakarta.validation.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    private Validator validator;

    public AddressTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidAddress() {
        Address validAddress = new Address(/* Initialize valid address here */);

        Set<ConstraintViolation<Address>> violations = validator.validate(validAddress);

        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalidAddress() {
        Address invalidAddress = new Address(/* Initialize invalid address here */);

        Set<ConstraintViolation<Address>> violations = validator.validate(invalidAddress);

        // Assert that there are violations based on the validation annotations in your Address class
        // Example: assertEquals(1, violations.size());
    }
}