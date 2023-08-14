package com.travelapp.controller;

import com.travelapp.dto.UserDTO;
import com.travelapp.entity.User;
import com.travelapp.form.UserCreateForm;
import com.travelapp.form.UserFilterForm;
import com.travelapp.form.UserUpdateForm;
import com.travelapp.service.interfaceService.IUserService;
import com.travelapp.validation.anotation.BookingExistsById;
import com.travelapp.validation.anotation.UserExistsById;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper mapper;

    //tìm tất cả user
    @GetMapping
    public Page<UserDTO> findAll(Pageable pageable, UserFilterForm userFilterForm) {
        Page<User> users = userService.findAllUsers(pageable, userFilterForm);
        List<UserDTO> userDTOS = mapper.map(
                users.getContent(),
                new TypeToken<List<UserDTO>>() {
                }.getType()
        );
        return new PageImpl<>(userDTOS, pageable, users.getTotalElements());
    }

    // tìm bằng Id
    @GetMapping("/{userId}")
    public UserDTO findById(@PathVariable("userId") @UserExistsById Integer userId) {
        User user = userService.findUserById(userId);
        return mapper.map(user, UserDTO.class);
    }

    // Tìm bằng Email
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<?> existsByEmail(@PathVariable(name = "email") String email) {
        // get entity
        boolean result = userService.existsUserByEmail(email);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //TÌm bằng userName
    @GetMapping(value = "/username/{userName}")
    public ResponseEntity<?> existsUserByUserName(@PathVariable(name = "userName") String userName) {
        // get entity
        boolean result = userService.existsUserByUserName(userName);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public void create(@RequestBody @Valid UserCreateForm userCreateForm) {
        userService.createUser(userCreateForm);
    }

    @PutMapping("/{userId}")
    public void update(@PathVariable("userId") @UserExistsById Integer userId, @RequestBody @Valid UserUpdateForm userUpdateForm) {
        userUpdateForm.setId(userId);
        userService.updateUser(userUpdateForm);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable("id") @UserExistsById Integer userId) {
        User userToDelete = userService.findUserById(userId);

        if (userToDelete == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("không tìm thấy User này");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Không thể xóa user có role là ADMIN");
            }
        }
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
    // phân trang
    @PostMapping("/search")
    public Page<User> search(@RequestBody UserFilterForm userFilterForm, Pageable pageable){
        return userService.search(userFilterForm, pageable);
    }

//
//    @DeleteMapping
//    public void deleteAll(@RequestBody List<@UserExistsById Integer> ids) {
//        userService.deleteAll(ids);
//    }
}
