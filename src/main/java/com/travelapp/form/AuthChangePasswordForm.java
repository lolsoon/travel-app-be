package com.travelapp.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AuthChangePasswordForm {
    @NotBlank(message = "{UserForm.userName.NotBlank}")
    @Length(max = 50, message = "{userForm.userName.Length}")
    private String userName;

    @NotBlank(message = "{UserForm.password.NotBlank}")
    @Length(max = 32, message = "{UserForm.password.Length}")
    private String password;
}
