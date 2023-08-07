package com.travelapp.validation.validator;

import com.travelapp.repository.IUserRepository;
import com.travelapp.validation.anotation.UserExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistsByIdValidator implements ConstraintValidator<UserExistsById, Integer> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(Integer userId, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.existsById(userId);
    }
}
