package com.travelapp.validation.validator;

import com.travelapp.repository.IUserRepository;
import com.travelapp.validation.anotation.UserExistsByName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistsByNameValidator implements ConstraintValidator<UserExistsByName, String> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.existsByUserName(userName);
    }
}
