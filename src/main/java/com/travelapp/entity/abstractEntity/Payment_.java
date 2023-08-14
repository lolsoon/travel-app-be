package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.*;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Ticket.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")

public class Payment_ {

    public static volatile SingularAttribute<Payment, Integer> paymentId;
    public static volatile SingularAttribute<Payment, Booking> booking;
    public static volatile SingularAttribute<Payment, User> user;
    public static volatile SingularAttribute<Payment, Double> amount;
    public static volatile SingularAttribute<Payment, LocalDateTime> paymentDate;
    public static volatile SingularAttribute<Payment, Payment.PaymentMethod> paymentMethod;
    public static volatile SingularAttribute<Payment, Payment.PaymentStatus> paymentStatus;


    public static final String PAYMENT_ID = "paymentId";
    public static final String BOOKING = "BOOKING";
    public static final String USER = "USER";
    public static final String AMOUNT = "amount";
    public static final String PAYMENTDATE = "paymentDate";
    public static final String PAYMENT_METHOD = "paymentMethod";
    public static final String PAYMENT_STATUS = "paymentStatus";

}
