package com.travelapp.entity.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class MomoPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "momo_transaction_id")
    private String momoTransactionId;

    @Column(name = "momo_phone_number")
    private String momoPhoneNumber;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
