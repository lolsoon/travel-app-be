package com.travelapp.dto;

import com.travelapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    public User toEntity() {
        return new User(id,userName, email, password,phoneNumber,address);
    }
}
