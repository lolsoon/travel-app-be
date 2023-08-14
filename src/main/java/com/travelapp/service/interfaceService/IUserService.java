package com.travelapp.service.interfaceService;

import com.travelapp.entity.User;
import com.travelapp.form.AuthChangePasswordForm;
import com.travelapp.form.UserCreateForm;
import com.travelapp.form.UserFilterForm;
import com.travelapp.form.UserUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void createUser(UserCreateForm userCreateForm);

    void updateUser(UserUpdateForm userUpdateForm);
    Page<User> findAllUsers(Pageable pageable, UserFilterForm filterForm);

    User findUserById(Integer userId);

    User findUserByUserName(String useName);

    User findUserByEmail (String email);

    boolean existsUserByEmail (String email);

    boolean existsUserByUserName(String userName);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

//    void saveUser(User user);

    void deleteUser(Integer userId);

    Page<User> search(UserFilterForm userFilterForm, Pageable pageable);
    void changePassword(AuthChangePasswordForm authChangePasswordForm);

//    Page<User> search(UserFilterForm userFilterForm);
}
