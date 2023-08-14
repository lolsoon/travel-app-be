package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.Hotel;
import com.travelapp.entity.Ticket;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.Locale;

@StaticMetamodel(Hotel.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")

public abstract class Hotel_ {
    public static volatile SingularAttribute<Hotel, Integer> hotelId;
    public static volatile SingularAttribute<Hotel, String> hotelName;
    public static volatile SingularAttribute<Hotel, String> address;
    public static volatile SingularAttribute<Hotel, String> phoneNumber;
    public static volatile SingularAttribute<Hotel, LocalDateTime> checkInDate;
    public static volatile SingularAttribute<Hotel, LocalDateTime> checkOutDate;
    public static volatile SingularAttribute<Hotel, Double> pricePerNight;
    public static volatile SingularAttribute<Hotel, Double> totalPrice;
    public static volatile ListAttribute<Hotel,Ticket> tickets;


    public static final String HOTEL_ID = "hotelId";
    public static final String HOTEL_NAME = "hotelName";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String CHECK_IN_DATE = "checkInDate";
    public static final String CHECK_OUT_DATE = "checkOutDate";
    public static final String PRICE_PER_NIGHT = "pricePerNight";
    public static final String TOTAL_PRICE = "totalPrice";
    public static final String TICKETS = "tickets";
}
