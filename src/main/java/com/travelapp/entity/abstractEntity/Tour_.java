package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.Tour;
import com.travelapp.entity.User;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Tour.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Tour_ {
    public static volatile SingularAttribute<Tour, String> tourName;
    public static volatile SingularAttribute<Tour, Integer> tourId;
    public static volatile SingularAttribute<Tour, String> description;
    public static volatile SingularAttribute<Tour, Double> price;
    public static volatile SingularAttribute<Tour, Double> salePrice;
    public static volatile SingularAttribute<Tour, Integer> duration;
    public static volatile SingularAttribute<Tour, String> thumbnailUrl;
    public static volatile SingularAttribute<Tour, String> destination;
    public static volatile SingularAttribute<Tour, LocalDateTime> startDate;
    public static volatile SingularAttribute<Tour, LocalDateTime> endDate;

    public static final String TOUR_NAME = "tourName";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String SALE_PRICE = "salePrice";
    public static final String TOURID = "tourId";
    public static final String DURATION = "duration";
    public static final String THUMBNAILURL = "thumbnailUrl";
    public static final String DESTINATION = "destination";
    public static final String STARTDATE = "startDate";
    public static final String ENDDATE = "endDate";
}
