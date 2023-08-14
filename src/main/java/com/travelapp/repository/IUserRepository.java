package com.travelapp.repository;

import com.travelapp.dto.UserDTO;
import com.travelapp.entity.User;
import com.travelapp.form.UserCreateForm;
import com.travelapp.form.UserUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    // Phương thức lấy thông tin người dùng bằng email
    User findUserByEmail(String email);

//
    // Phương thức kiểm tra người dùng có tồn tại theo email
    public boolean existsByEmail(String email);


    User findUserByUserName(String userName);

    boolean existsUserByUserName(String userName);

    @Modifying
    @Query("UPDATE User SET password = :password WHERE userName = :userName")
    void changePassword(String userName, String password);
}
