package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.exception.AppException;
import com.example.Ecommerce.exception.ErrorCode;
import com.example.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();  // tạo một đối tượng User

        if (userRepository.existsByUsername(request.getUsername()))
            throw  new AppException(ErrorCode.USER_EXISTS);
//        set dữ liê vào đối tượng mapdata
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

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
        User user = getUserById(userId); // lấy ra 1 user theo id cần đổi tên
//        update user đó

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
//     xóa user
    public void  deleteUser(String userId) {
       userRepository.deleteById(userId);
    }
}
