package com.dultek.ums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormData {
    private Employee employee;
    private Address address;
    private UserCredentials userCredentials;
    private UserRole userRole;
}
