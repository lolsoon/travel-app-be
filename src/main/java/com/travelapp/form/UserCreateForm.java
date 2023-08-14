package com.travelapp.form;

import com.travelapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateForm extends User {
    @NotBlank(message = "{UserForm.userName.NotBlank}")
    @Length(max = 50, message = "{UserForm.userName.Length}")
    private String userName;

    @NotBlank(message = "{UserForm.email.NotBlank}")
    @Length(max = 50, message = "{UserForm.email.Length}")
    private String email;

    @NotBlank(message = "{UserForm.password.NotBlank}")
    @Length(max = 32, message = "{UserForm.password.Length}")
    private String password;

    @NotBlank(message = "{UserForm.firstName.NotBlank}")
    @Length(max = 50, message = "{UserForm.firstName.Length}")
    private String firstName;

    @NotBlank(message = "{UserForm.lastName.NotBlank}")
    @Length(max = 50, message = "{UserForm.lastName.Length}")
    private String lastName;

    @NotNull(message = "{UserForm.role.NotNull}")
    private UserRole userRole = getUserRole();
}
