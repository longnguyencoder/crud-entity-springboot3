package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.exception.AppException;
import com.example.Ecommerce.exception.ErrorCode;
import com.example.Ecommerce.mapper.UserMapper;
import com.example.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw  new AppException(ErrorCode.USER_EXISTS);
//        set dữ liê vào đối tượng mapdata
        User user = userMapper.toUser(request);  // tạo một đối tượng User
//     mapp dữ liệu


// lưu dữ liệu vào data
        return userRepository.save(user);

    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found")); // nếu tìm thấy user thì trả về
    }

//    update user
    public User UpdateUser(String userId, UserUpdateRequest request ) {
         // lấy ra 1 user theo id cần đổi tên
//        update user đó không cho update username

//        User user = userMapper.toUser(request);
// map dữ liệu
        User user = getUserById(userId);
        userMapper.updateUser(user,request);

        return userRepository.save(user);
    }
//     xóa user
    public void  deleteUser(String userId) {
       userRepository.deleteById(userId);
    }
}
