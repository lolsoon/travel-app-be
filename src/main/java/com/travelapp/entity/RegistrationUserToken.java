package com.travelapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Registration_User_Token")
public class RegistrationUserToken implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", unique = true, nullable = false)
    private int id;

    @Column(name = "`token`", nullable = false, length = 36, unique = true)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "account_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`expiryDate`", nullable = false)
    private Date expiryDate;

    public RegistrationUserToken() {
    }

    public RegistrationUserToken(String token, User user) {
        this.token = token;
        this.user = user;

        // 1h
        expiryDate = new Date(System.currentTimeMillis() + 360000);
    }
}
