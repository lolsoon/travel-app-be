package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`user_id`", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "`username`", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "`email`", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "`password`", nullable = false, length = 800)
    private String password;

    @Column(name = "`first_name`", nullable = false, length = 50)
    private String firstName;

    @Column(name = "`last_name`", nullable = false, length = 50)
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;
    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "card_id", nullable = false, length = 12, unique = true)
    private String cardId;

    @Column(name = "role", length = 8, nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'EMPLOYEE'")
    private UserRole userRole = UserRole.EMPLOYEE;

//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status", nullable = false)
//    private UserStatus status = UserStatus.NOT_ACTIVE;

    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updatedDate", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public enum UserRole {
        ADMIN, USER, EMPLOYEE
    }

}
