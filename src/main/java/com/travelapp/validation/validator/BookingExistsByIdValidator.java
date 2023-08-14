package com.travelapp.validation.validator;

import com.travelapp.repository.IBookingRepository;
import com.travelapp.validation.anotation.BookingExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookingExistsByIdValidator implements ConstraintValidator<BookingExistsById, Integer> {
    @Autowired
    private IBookingRepository bookingRepository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return bookingRepository.existsById(id);
    }
}
