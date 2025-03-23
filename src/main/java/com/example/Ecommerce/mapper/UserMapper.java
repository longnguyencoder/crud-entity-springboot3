package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.dto.response.UserResponse;
import com.example.Ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
