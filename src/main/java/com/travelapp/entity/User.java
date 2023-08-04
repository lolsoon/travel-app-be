package com.travelapp.entity;

import com.travelapp.entity.payment.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", unique = true, nullable = false)
    private Integer id;

    @Column(name = "`username`", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "`email`", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "`password`", nullable = false, length = 800)
    private String password;

    @Column(name = "`firstName`", nullable = false, length = 50)
    private String firstName;

    @Column(name = "`lastName`", nullable = false, length = 50)
    private String lastName;

    @Column(name = "phoneNumber", nullable = true)
    private String phoneNumber;

    @Column(name = "address", nullable = true)
    private String address;

//    @Column(name = "cardId", nullable = false, length = 12, unique = true)
//    private String cardId;

    @Column(name = "role", length = 8, nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'EMPLOYEE'")
    private Role role = Role.EMPLOYEE;

//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status", nullable = false)
//    private UserStatus status = UserStatus.NOT_ACTIVE;

//    @Column(name = "createdDate", nullable = false, updatable = false)
//    @CreationTimestamp
//    private LocalDateTime createdDate;
//
//    @Column(name = "updatedDate", nullable = false)
//    @CreationTimestamp
//    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;

    public User(Integer id, String userName, String email, String password, String phoneNumber, String address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(String userName, String password, List<GrantedAuthority> authorities) {
    }

    public enum Role {
        ADMIN, USER, EMPLOYEE
    }
}
