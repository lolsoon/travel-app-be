package com.travelapp.service.interfaceService;

import com.travelapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void createUser(User user);

    List<User> getAllUsers();

    User findUserById(Integer userId);

    User findUserByUserName(String useName);

    User findUserByEmail (String email);

    boolean existsUserByEmail (String email);

    boolean existsUserByUserName(String userName);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void saveUser(User user);

    void deleteUser(Integer userId);
}
