package com.travelapp.entity.abstractEntity;

import com.travelapp.entity.Order;
import com.travelapp.entity.Ticket;
import com.travelapp.entity.User;
import org.aspectj.weaver.ast.Or;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.Locale;

@StaticMetamodel(Order.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")

public abstract class Order_ {
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, User> user;
    public static volatile SingularAttribute<Order, LocalDateTime> createDate;
    public static volatile SingularAttribute<Order, Ticket> ticket;
    public static volatile SingularAttribute<Order, Integer> quantity;
    public static volatile SingularAttribute<Order, Order.OrderStatus> orderStatus;

    public static final String ORDER_ID = "orderId";
    public static final String USER = "user";
    public static final String CREATEDATE = "createDate";
    public static final String QUANTITY = "quantity";
    public static final String ORDER_STATUS = "orderStatus";

}
