package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {
//    JpaRepository là repository làm việc với entity j và khai báo kiểu dữ liệu cho nó
//     ở đây làm việc với user và kiểu dữ liệu là String
    boolean existsByUsername(String username);


}
