package com.travelapp.specification;

import com.travelapp.entity.Payment;
import com.travelapp.entity.abstractEntity.Payment_;
import com.travelapp.entity.abstractEntity.User_;
import com.travelapp.form.PaymentFilterForm;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class PaymentSpecification {
    public static Specification<Payment> buildWhere(PaymentFilterForm paymentFilterForm) {
        if (paymentFilterForm == null) {
            return null;
        }
        {
            return hasUserIdEqualTo(paymentFilterForm.getUserId())
                    .and(hasPaymentStatusEqualTo(paymentFilterForm.getPaymentStatus()))
                    .and(hasPaymentMethodEqualTo(paymentFilterForm.getPaymentMethod()))
                    .and(hasDateInRange(paymentFilterForm.getStartDate(), paymentFilterForm.getEndDate()));
        }
    }

    public static Specification<Payment> hasUserIdEqualTo(Integer userId) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (userId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get(Payment_.user).get(User_.userId), userId);
        });
    }

    public static Specification<Payment> hasPaymentStatusEqualTo(Payment.PaymentStatus paymentStatus) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (paymentStatus == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get(Payment_.paymentStatus), paymentStatus);
        });
    }

    public static Specification<Payment> hasPaymentMethodEqualTo(Payment.PaymentMethod paymentMethod) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (paymentMethod == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get(Payment_.paymentMethod), paymentMethod);
        });
    }

    public static Specification<Payment> hasDateInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.greaterThanOrEqualTo(root.get(Payment_.paymentDate), startDate),
                criteriaBuilder.lessThanOrEqualTo(root.get(Payment_.paymentDate), endDate)
        );

    }
};

