package com.facelesscoder.user_registration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author KK
 * @created 10/03/2026 - 18:14
 * @project user-registration
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email_id"))
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String emailId;

    @Column(nullable = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String addressLine3;

    @Column(nullable = false)
    private Integer zipcode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    private String updatedBy;

    public static enum Role {
        CUSTOMER,
        AGENT
    }

    public static enum Status {
        NEW,
        ACTIVE,
        INACTIVE
    }
}

