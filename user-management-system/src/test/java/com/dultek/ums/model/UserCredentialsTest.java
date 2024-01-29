package com.dultek.ums.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserCredentialsTest {

    private Validator validator;

    public UserCredentialsTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidUserCredentials() {
        UserCredentials validUserCredentials = new UserCredentials(/* Initialize valid user credentials here */);

        Set<ConstraintViolation<UserCredentials>> violations = validator.validate(validUserCredentials);

        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalidUserCredentials() {
        UserCredentials invalidUserCredentials = new UserCredentials(/* Initialize invalid user credentials here */);

        Set<ConstraintViolation<UserCredentials>> violations = validator.validate(invalidUserCredentials);

        // Assert that there are violations based on the validation annotations in your UserCredentials class
        // Example: assertEquals(1, violations.size());
    }
}