package com.dultek.ums.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1000)
	private Long id;

	@NotBlank
	// Employee ID following the specified format (e.g., AO1000)
	@NotBlank(message = "Employee ID is required")
	@Pattern(regexp = "^[A-Z]{2}\\d{4}$", message = "Invalid Employee ID format, must be two uppercase letters followed by four digits")
	private String employeeId;

	/*
	 JPA will automatically manage a version number. If two transactions attempt
	 to update the same entity simultaneously, the one that commits first will succeed,
	 and the other will fail.
	 */
	@Version
	private Long version;

	@NotBlank(message = "First name is required")
	@Size(max = 255, message = "First name must be less than 255 characters")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(max = 255, message = "Last name must be less than 255 characters")
	private String lastName;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@Embedded
	private Address address;

	@NotBlank(message = "SSN is required")
	@Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$", message = "Invalid SSN format, must be ###-##-####")
	private String ssn;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private UserCredentials credentials;

}

