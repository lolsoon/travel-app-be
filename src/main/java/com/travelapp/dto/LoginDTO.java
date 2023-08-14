package com.travelapp.dto;

import com.travelapp.entity.User;

public class LoginDTO {
    private int userId;
    private String username;
    private User.UserRole userRole;
    private String fullName;
    private String token;
}
