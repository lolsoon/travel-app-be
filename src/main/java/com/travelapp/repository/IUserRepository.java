package com.travelapp.repository;

import com.travelapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    // Phương thức lấy thông tin người dùng bằng ID
    User findUserById(int userId);

    // Phương thức lấy thông tin người dùng bằng tên đăng nhập
    User findUserByUserName(String userName);

    // Phương thức lấy thông tin người dùng bằng email
    User findUserByEmail(String email);

    // Phương thức lấy danh sách tất cả người dùng
    List<User> getAllUsers();

    // Phương thức kiểm tra người dùng có tồn tại theo tên
    public boolean existsByUserName(String userName);

    // Phương thức kiểm tra người dùng có tồn tại theo email
    public boolean existsByEmail(String email);

    // Phương thức thêm người dùng mới
    void addUser(User user);

    // Phương thức cập nhật thông tin người dùng
    void updateUser(User user);

    // Phương thức xóa người dùng
    void deleteUser(int userId);
}
