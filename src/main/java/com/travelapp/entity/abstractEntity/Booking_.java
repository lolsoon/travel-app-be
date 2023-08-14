package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.Booking;
import com.travelapp.entity.Flight;
import com.travelapp.entity.Hotel;
import com.travelapp.entity.Ticket;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Booking.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")

public abstract class Booking_ {
    public static volatile SingularAttribute<Booking, Integer> bookingId;
    public static volatile SingularAttribute<Booking, String> fullName;
    public static volatile SingularAttribute<Booking, String> email;
    public static volatile SingularAttribute<Booking, String> phoneNumber;
    public static volatile SingularAttribute<Booking, String> address;
    public static volatile SingularAttribute<Booking, Double> totalAmount;
    public static volatile SingularAttribute<Booking, Integer> numberOfPeople;
    public static volatile SingularAttribute<Booking, LocalDateTime> bookingDate;
    public static volatile SingularAttribute<Booking, String> note;
    public static volatile SingularAttribute<Booking, Ticket> ticket;

    public static final String BOOKING_ID = "bookingId";
    public static final String FULL_NAME = "fullName";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String ADDRESS = "address";
    public static final String TOTAL_AMOUNT = "totalAmount";
    public static final String NUMBER_OF_PEOPLE = "numberOfPeople";
    public static final String BOOKING_DATE = "bookingDate";
    public static final String NOTE = "note";
    public static final String TIKCET = "ticket";
}
