package com.travelapp.repository;

import com.travelapp.entity.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    Order findOrderById(int orderId);

    // Ví dụ: Lấy danh sách Order theo User
    List<Order> findByUser(User user);

    // Lấy danh sách Order theo trạng thái (OrderStatus)
    List<Order> findByStatus(OrderStatus status);

    // Lấy danh sách Order theo ngày đặt hàng
    List<Order> findByOrderDate(Date orderDate);

    List<Order> findOrderByLocation(Location locationName);
    List<Order> findOrderByFlightCode(Flight flightCode);

    List<Order> findOrdersByUserAndStatus(User user, OrderStatus status);


    // Muốn thêm theo FlightId, HotelId, LocationId,PaymentId thì thêm sau
}
