package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.ApiResponse;
import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
// tạo mới một user
    @PostMapping()
   ApiResponse <User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));
       return apiResponse;
    }
//    lấy tất cả các users
    @GetMapping()
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//     lấy Users theo id
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String  userId) {
//        gọi xuống service tầng dưới của controller
        return userService.getUserById(userId);
    }
//    update thông tin user
    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.UpdateUser(userId, request);
    }
//    xóa tất User theo id
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "user has been deleted";
    }

}
