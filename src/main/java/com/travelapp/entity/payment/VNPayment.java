package com.travelapp.entity.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class VNPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vnpay_transaction_id")
    private String vnpayTransactionId;

    @Column(name = "vnpay_bank_code")
    private String vnpayBankCode;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
