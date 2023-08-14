package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.Flight;
import com.travelapp.entity.Hotel;
import com.travelapp.entity.Ticket;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Flight.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")

public abstract class Flight_ {
    public static volatile SingularAttribute<Flight, Integer> flightId;
    public static volatile SingularAttribute<Flight, String> flightCode;
    public static volatile SingularAttribute<Flight, LocalDateTime> departureDate;
    public static volatile SingularAttribute<Flight, LocalDateTime> arrivalDate;
    public static volatile SingularAttribute<Flight, String> destination;
    public static volatile SingularAttribute<Flight, String> airLineName;
    public static volatile SingularAttribute<Flight, Double> price;
    public static volatile ListAttribute<Flight,Ticket> tickets;


    public static final String FLIGHT_ID = "flightId";
    public static final String FLIGHT_CODE = "flightCode";
    public static final String DEPARTUREDATE = "departureDate";
    public static final String ARRIVALDATE = "arrivalDate";
    public static final String DESTINATION = "destination";
    public static final String AIR_LINE_NAME = "airLineName";
    public static final String PRICE = "price";
    public static final String TICKETS = "tickets";
}
