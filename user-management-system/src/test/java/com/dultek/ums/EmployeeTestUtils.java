package com.dultek.ums;

import com.dultek.ums.model.Address;
import com.dultek.ums.model.Employee;
import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTestUtils {

    public static Employee createSampleEmployeeUpdate() {

        return new Employee(
                "Maimuna",                  // First Name
                "MunaMuna",                   // Last Name
                "Maimuna.muna@example.com"      // Email
        );
    }

    public static Employee createValidEmployee() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Cityville");
        address.setState("State");
        address.setZipCode("12345");


        UserCredentials credentials = new UserCredentials();
        credentials.setUsername("john.doe");
        credentials.setPassword("password");
        credentials.setRole(UserRole.EMPLOYEE);

        return new Employee(
                "AO1000", // Replace with a valid employee ID
                "John",
                "Doe",
                "john.doe@example.com",
                address,
                "123-45-6789",
                credentials
        );
    }

    @Test
    public static Employee createInvalidEmployee() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Cityville");
        address.setState("State");
        address.setZipCode("12345");

        UserCredentials credentials = new UserCredentials();
        credentials.setUsername("marry.doe");
        credentials.setPassword("password");
        credentials.setRole(UserRole.EMPLOYEE);

        return new Employee(
                "AO1001", // Replace with a valid employee ID
                null,
                "Doe",
                "marry.doe@example.com",
                address,
                "123-45-9876",
                credentials
        );

    }
}

