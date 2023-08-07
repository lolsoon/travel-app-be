package com.travelapp.service;

import com.travelapp.entity.*;
import com.travelapp.repository.ILocationRepository;
import com.travelapp.repository.IOrderRepository;
import com.travelapp.repository.IUserRepository;
import com.travelapp.service.interfaceService.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public void createOrder(Order order) {
        // Kiểm tra tính hợp lệ của thông tin trong đơn hàng
        if (!isValidOrder(order)) {
            throw new IllegalArgumentException("Thông tin đơn hàng không hợp lệ");
        }

        // Kiểm tra tính hợp lệ của đơn hàng trước khi lưu vào cơ sở dữ liệu
        if (!isValidOrderDetails(order)) {
            throw new IllegalArgumentException("Đơn hàng không hợp lệ, " +
                    "kiểm tra các thông tin như chuyến bay, " +
                    "khách sạn, địa điểm, thanh toán và người dùng");
        }

        // Tính tổng số tiền của đơn hàng
        double totalAmount = order.calculateTotalAmount();
        order.setTotalAmount(totalAmount);

        // Lưu thông tin đơn hàng vào cơ sở dữ liệu
        orderRepository.save(order);
    }

    // Kiểm tra tính hợp lệ của thông tin trong đơn hàng
    private boolean isValidOrder(Order order) {
        // Thực hiện kiểm tra các thông tin cần thiết trong đơn hàng, trả về true nếu hợp lệ, ngược lại trả về false
        if (order.getFlight() == null || order.getHotel() == null || order.getLocation() == null ||
                order.getUser() == null || order.getPayment() == null || order.getOrderDate() == null) {
            throw new IllegalArgumentException("Thông tin đơn hàng không đầy đủ");
        }
        return true;
    }

    // Kiểm tra tính hợp lệ của đơn hàng trước khi lưu vào cơ sở dữ liệu
    private boolean isValidOrderDetails(Order order) {
        // Thực hiện kiểm tra các thông tin như chuyến bay, khách sạn, địa điểm, thanh toán và người dùng có hợp lệ không
        return order.getFlight() != null && order.getHotel() != null && order.getLocation() != null && order.getUser() != null;
    }


    @Override
    public void updateOrder(Order order) {
        // Lấy thông tin người dùng hiện tại từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Người dùng chưa đăng nhập");
        }
        //Kiểm tra Admin role hay không
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
        if (!isAdmin) {
            throw new IllegalArgumentException("Không có quyền update order");
        }
        // Lưu vào repo
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("order không tồn tại!");
        }
        orderRepository.delete(order);
    }

    @Override
    public double calculateTotalAmount(Order order) {
        double flightPrice = order.getFlight().getPrice();
        double hotelPrice = order.getHotel().getPrice();

        double totalAmount = flightPrice + hotelPrice;
        return totalAmount;
        // Chưa xử lý xong Logic
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        User user = userRepository.findUserById(userId);

        if (user == null) {
            throw new IllegalArgumentException("Không tìm thấy người dùng với ID: " + userId);
        }

        List<Order> orders = orderRepository.findByUser(user);
        return orders;
    }

    @Override
    public List<Order> findOrdersByLocationName(String locationName) {
        Location location = locationRepository.findLocationByName(locationName);

        if (location == null) {
            throw new IllegalArgumentException("Không tìm thấy địa điểm " + locationName);
        }

        List<Order> orders = orderRepository.findOrderByLocation(location);
        return orders;
    }

    @Override
    public List<Order> findOrderByStatus(OrderStatus orderStatus) {
        List<Order> orders = orderRepository.findByStatus(orderStatus);
        return orders;
    }

    @Override
    public List<Order> findOrdersByUserAndStatus(Integer userId, OrderStatus status) {
        User user = userRepository.findUserById(userId);

        if (user == null) {
            // Nếu userId không tồn tại
            throw new IllegalArgumentException("UserId không tồn tại");
        }

        List<Order> orders = orderRepository.findOrdersByUserAndStatus(user, status);
        return orders;

    }
}
