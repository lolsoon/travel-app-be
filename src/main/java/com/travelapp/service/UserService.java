package com.travelapp.service;

import com.travelapp.entity.User;
import com.travelapp.form.AuthChangePasswordForm;
import com.travelapp.form.UserCreateForm;
import com.travelapp.form.UserFilterForm;
import com.travelapp.form.UserUpdateForm;
import com.travelapp.repository.IUserRepository;
import com.travelapp.service.interfaceService.IUserService;
import com.travelapp.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<User> findAllUsers(Pageable pageable, UserFilterForm filterForm) {
        return userRepository.findAll(UserSpecification.buildWhere(filterForm),pageable);
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
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
        return userRepository.existsUserByUserName(userName);
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
                .roles(user.getUserRole().toString())
                .build();
    }


//    @Override
//    public void saveUser(User user) {
//        // Kiểm tra tính hợp lệ của thông tin người dùng
//        if (!isValidUser(user)) {
//            throw new IllegalArgumentException("Thông tin người dùng không hợp lệ");
//        }
//
//        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
//        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(hashedPassword);
//
//        // Lưu thông tin người dùng vào cơ sở dữ liệu thông qua userRepository
//        userRepository.save(user);
//    }

    @Override
    public void createUser(UserCreateForm userCreateForm) {
        String hash = passwordEncoder.encode(userCreateForm.getPassword());
        User user = mapper.map(userCreateForm, User.class);
        user.setPassword(hash);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserUpdateForm userUpdateForm) {
        userRepository.save(mapper.map(userUpdateForm, User.class));
    }

    @Override
    public void deleteUser(Integer userId) {
            // Kiểm tra xem người dùng có tồn tại không
        User user = userRepository.findById(userId).orElse(null);
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
    @Override
    public Page<User> search(UserFilterForm userFilterForm, Pageable pageable) {

        Specification<User> condition = UserSpecification.buildWhere(userFilterForm);

        return userRepository.findAll(condition,pageable);
    }
    @Override
    @Transactional
    public void changePassword(AuthChangePasswordForm authChangePasswordForm) {
        userRepository.changePassword(authChangePasswordForm.getUserName(), passwordEncoder.encode(authChangePasswordForm.getPassword()));
    }
}
