package com.travelapp.validation.validator;

import com.travelapp.repository.ITicketRepository;
import com.travelapp.validation.anotation.TicketExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TicketExistsByIdValidator implements ConstraintValidator<TicketExistsById, Integer> {
    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public boolean isValid(Integer ticketId, ConstraintValidatorContext constraintValidatorContext) {
        return ticketRepository.existsById(ticketId);
    }
}
