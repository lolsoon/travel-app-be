package com.travelapp.repository;
import com.travelapp.entity.payment.MomoPayment;
import com.travelapp.entity.payment.Payment;
import com.travelapp.entity.payment.VNPayment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPaymentRepository {

    // Tìm kiếm Payment bằng user_id
    List<Payment> findByUserId(Integer userId);

    // Tìm kiếm Payment bằng payment_date
    List<Payment> findByPaymentDate(Date paymentDate);

    // Tìm kiếm Payment bằng momoPayment
    @Query("SELECT p FROM Payment p WHERE p.momoPayment = ?1")
    List<Payment> findByMomoPayment(MomoPayment momoPayment);

    // Tìm kiếm Payment bằng vnPayment
    @Query("SELECT p FROM Payment p WHERE p.vnpayPayment = ?1")
    List<Payment> findByVNPayment(VNPayment vnPayment);
}

