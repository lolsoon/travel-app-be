package com.travelapp.form;

import com.travelapp.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFilterForm {
    private String search;
    private User.Role role;
    private Integer minId;
    private Integer maxId;
}
