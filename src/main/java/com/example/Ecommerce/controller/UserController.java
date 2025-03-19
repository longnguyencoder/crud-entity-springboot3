package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.ApiResponse;
import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.dto.response.UserResponse;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
// tạo mới một user
    @PostMapping()
   ApiResponse <UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
//    lấy tất cả các users
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers(){
    return ApiResponse.<List<UserResponse>>builder()
            .result(userService.getUsers())
            .build();
}

//     lấy Users theo id
            @GetMapping("/{userId}")
                ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId){
                return ApiResponse.<UserResponse>builder()
                    .result(userService.getUser(userId))
                     .build();
}
    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }

}
