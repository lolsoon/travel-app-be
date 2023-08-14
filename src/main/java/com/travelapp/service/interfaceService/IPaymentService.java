package com.travelapp.service.interfaceService;

import com.travelapp.entity.User;
import com.travelapp.entity.Payment;

import java.util.Date;
import java.util.List;

public interface IPaymentService {

    void createPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(Integer paymentId);

    Payment getPaymentById(Integer paymentId);

    List<Payment> getPaymentsByUserId(Integer userId);

    List<Payment> findByPaymentMethod(Payment.PaymentMethod paymentMethod);

    List<Payment> findByPaymentDateBetween(Date startDate, Date endDate);

    List<Payment> getAllPayments();

    //Lấy danh sách thanh toán của một người dùng với số tiền lớn hơn một giá trị cho trước.
//    List<Payment> getPaymentsByUserAndAmountGreaterThan(User user, double amount);
    // Lấy danh sách thanh toán của một người dùng trong khoảng thời gian cụ thể.
//    List<Payment> getPaymentsByUserAndPaymentDateBetween(User user, Date startDate, Date endDate);
    //Tính tổng số tiền thanh toán của một người dùng.
//    double getTotalPaymentsByUserId(Integer userId);
    //Tính tổng số tiền thanh toán của một người dùng trong khoảng thời gian cụ thể.
//    double getTotalPaymentsByUserAndPaymentDateBetween(User user, Date startDate, Date endDate);

}
