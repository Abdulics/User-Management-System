package com.dultek.ums.service;

import com.dultek.ums.model.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.UUID;

@SpringBootTest
public class EmployeeTestUtils {

    /**
     * Creates a sample Employee with unique credentials.
     *
     * @return A sample Employee instance with unique credentials.
     */
    public static Employee createSampleEmployee() {
        // Arrange
        UserRole userRole = new UserRole();
        userRole.setRole(Collections.singleton(Role.EMPLOYEE));

        // Use a unique identifier in the username and password to avoid conflicts
        String uniqueIdentifier = UUID.randomUUID().toString().substring(0, 8);

        UserCredentials userCredentials = UserCredentials.builder()
                .username("doe" + uniqueIdentifier)
                .password("password" + uniqueIdentifier)
                .role(userRole)
                .build();

        Address address = Address.builder()
                .city("Omaha")
                .state("Nebraska")
                .street("123 Main St")
                .zipCode("68111")
                .build();

        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe" + uniqueIdentifier + "@email.com")
                .address(address)
                .ssn("123-45-6790")
                .roles((userRole))
                .credentials(userCredentials)
                .build();

        // Set roles and credentials without circular references
        // Set bidirectional association
        userRole.setEmployee(employee);
        address.setEmployee(employee);
        address.setEmployeeId(employee.getEmployeeId());
        userCredentials.setEmployee(employee);

        return employee;
    }

    public static Employee createValidEmployee() {
       // Address address = new Address("123 Main St", "City", "State", "12345-6789");

        UserCredentials credentials = new UserCredentials();
        credentials.setUsername("john.doe");
        credentials.setPassword("password");
        //credentials.setRole(UserRole.EMPLOYEE);

        return new Employee(

        );
    }

    public static Employee createInvalidEmployee() {
        //Address address = new Address("123 Main St", "City", "State", "12345-6789");

        UserCredentials credentials = new UserCredentials();
        credentials.setUsername("marry.doe");
        credentials.setPassword("password");
        //credentials.setRole(UserRole.EMPLOYEE);

        return new Employee(
                //"AO1001", // Replace with a valid employee ID
                //null,
                //"Doe",
               // "marry.doe@example.com",
               // address,
               // "123-45-9876",
                //credentials
        );

    }
}

