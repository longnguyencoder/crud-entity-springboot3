package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.dto.response.UserResponse;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.exception.AppException;
import com.example.Ecommerce.exception.ErrorCode;
import com.example.Ecommerce.mapper.UserMapper;
import com.example.Ecommerce.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    public UserResponse createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw  new AppException(ErrorCode.USER_EXISTS);
//        set dữ liê vào đối tượng mapdata
        User user = userMapper.toUser(request);  // tạo một đối tượng User
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//     mapp dữ liệu


// lưu dữ liệu vào data
        return userMapper.toUserResponse(userRepository.save(user));

    }
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

//    update user
public UserResponse updateUser(String userId, UserUpdateRequest request) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    userMapper.updateUser(user, request);

    return userMapper.toUserResponse(userRepository.save(user));
}
//     xóa user
    public void  deleteUser(String userId) {
       userRepository.deleteById(userId);
    }
}
