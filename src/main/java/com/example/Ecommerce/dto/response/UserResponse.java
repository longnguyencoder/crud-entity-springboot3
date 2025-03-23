package com.example.Ecommerce.dto.response;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.enums.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstname;
    String lastname;
    LocalDate dob;
    Set<String> roles;
}
