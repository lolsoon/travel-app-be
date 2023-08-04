package com.travelapp.service;

import com.travelapp.entity.User;
import com.travelapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User findUserByUserName(String useName) {
        return userRepository.findUserByUserName(useName);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsUserByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Kiểm tra xem username có tồn tại trong cơ sở dữ liệu không
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng với username: " + userName);
        }

        // Tạo đối tượng UserDetails từ thông tin người dùng
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }


    @Override
    public void saveUser(User user) {
        // Kiểm tra tính hợp lệ của thông tin người dùng
        if (!isValidUser(user)) {
            throw new IllegalArgumentException("Thông tin người dùng không hợp lệ");
        }

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Lưu thông tin người dùng vào cơ sở dữ liệu thông qua userRepository
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
            // Kiểm tra xem người dùng có tồn tại không
        User user = userRepository.findUserById(userId);
        if (user == null) {
            // Nếu người dùng không tồn tại ném một ngoại lệ thông báo lỗi
            throw new IllegalArgumentException("Người dùng không tồn tại");
        }

        // Xóa thông tin người dùng khỏi database thông qua userRepository
        userRepository.delete(user);
    }

    private boolean isValidUser(User user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
}
