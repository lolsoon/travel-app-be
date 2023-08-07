package com.travelapp.service.interfaceService;

import com.travelapp.entity.Order;
import com.travelapp.entity.OrderStatus;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Integer orderId);

    double calculateTotalAmount(Order order);

    Order findOrderById(Integer orderId);

    List<Order> findAllOrders();

    List<Order> findOrderByUserId(Integer userId);

    List<Order> findOrdersByLocationName(String locationName);

    List<Order> findOrderByStatus(OrderStatus orderStatus);

    List<Order> findOrdersByUserAndStatus(Integer userId, OrderStatus status);
}
