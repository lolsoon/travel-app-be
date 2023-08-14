package com.travelapp.form;

import com.travelapp.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFilterForm extends FormBase{
    private String search;
    private User.UserRole userRole;
    private Integer minId;
    private Integer maxId;
    private String phoneNumber;
    private String cardId;
}
