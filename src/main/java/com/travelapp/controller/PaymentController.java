package com.travelapp.controller;

import com.travelapp.entity.Payment;
import com.travelapp.service.interfaceService.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping
    public void createPayment(@RequestBody Payment payment) {
        paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public void updatePayment(@PathVariable("id") int paymentId, @RequestBody Payment payment) {
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") int paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
