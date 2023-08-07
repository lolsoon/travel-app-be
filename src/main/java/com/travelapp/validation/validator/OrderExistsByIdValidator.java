package com.travelapp.validation.validator;

import com.travelapp.repository.IOrderRepository;
import com.travelapp.validation.anotation.OrderExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderExistsByIdValidator implements ConstraintValidator<OrderExistsById, Integer> {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public boolean isValid(Integer orderId, ConstraintValidatorContext constraintValidatorContext) {
        return orderRepository.existsById(orderId);
    }

}
