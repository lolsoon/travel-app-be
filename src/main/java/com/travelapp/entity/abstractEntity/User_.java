package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.User;
import com.travelapp.entity.UserStatus;

import javax.annotation.Generated;
import javax.management.relation.Role;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, UserStatus> status;

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String USERNAME = "userName";
    public static final String STATUS = "status";
}
