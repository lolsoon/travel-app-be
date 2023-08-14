package com.travelapp.repository;
import com.travelapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    // Tìm kiếm Payment bằng user_id
    List<Payment> findByUserId(Integer userId);

    // tìm kiếm bằng phương thức thanh toán
    List<Payment> findByPaymentMethod(Payment.PaymentMethod paymentMethod);

    List<Payment> findByPaymentDateBetween(Date startDate, Date endDate);

    List<Payment> getAllPayments();

//    List<Payment> findByUserAndAmountGreaterThan(User user, double amount);
//
//    List<Payment> findByUserAndPaymentDateBetween(User user, Date startDate, Date endDate);

//    double getTotalPaymentsByUserId(Integer userId);
//
//    double getTotalPaymentsByUserAndPaymentDateBetween(User user, Date startDate, Date endDate);
}

