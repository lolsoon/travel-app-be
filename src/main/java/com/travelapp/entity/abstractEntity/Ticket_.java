package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.*;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.time.LocalDateTime;

@StaticMetamodel(Ticket.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Ticket_ {
    public static volatile SingularAttribute<Ticket, Integer> ticketId;
    public static volatile SingularAttribute<Ticket, Flight> flight;
    public static volatile SingularAttribute<Ticket, Hotel> hotel;
    public static volatile ListAttribute<Ticket, Booking> bookings;
    public static volatile SingularAttribute<Ticket, String> departureLocation;
    public static volatile SingularAttribute<Ticket, String> destination;
    public static volatile SingularAttribute<Ticket, LocalDateTime> departureDate;
    public static volatile SingularAttribute<Ticket, LocalDateTime> returnDate;
    public static volatile SingularAttribute<Ticket, Double> price;
    public static volatile SingularAttribute<Ticket, Integer> quantity;


    public static final String TICKET_ID = "ticketId";
    public static final String FLIGHTID = "flightId";
    public static final String HOTELID = "hotelId";
    public static final String BOOKINGS = "bookings";
    public static final String DEPARTURELOCATION = "departureLocation";
    public static final String DESTINATION = "destination";
    public static final String DEPARTUREDATE = "departureDate";
    public static final String RETURNDATE = "returnDate";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";
}
