package com.dultek.ums.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    @JsonBackReference
//    private Employee employee;


    @OneToOne
    @MapsId
    @JoinColumn(
            name = "credential_id",
            referencedColumnName = "credentialId",
            unique = true,
            nullable = false
    )
    @JsonBackReference
    @JsonManagedReference
    UserCredentials userCredentials;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles", nullable = false)
    private Set<Role> role;

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", role=" + role +
                '}';
    }
}

