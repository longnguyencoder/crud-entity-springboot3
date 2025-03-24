package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.request.UserCreationRequest;
import com.example.Ecommerce.dto.request.UserUpdateRequest;
import com.example.Ecommerce.dto.response.UserResponse;
import com.example.Ecommerce.entity.Role;
import com.example.Ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toUser(UserCreationRequest request);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToStrings")
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    // Chuyển Set<Role> -> Set<String>
    @Named("mapRolesToStrings")
    default Set<String> mapRolesToStrings(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    // Chuyển Set<String> -> Set<Role>
    @Named("mapStringsToRoles")
    default Set<Role> mapStringsToRoles(Set<String> roleNames) {
        if (roleNames == null) return null;
        return roleNames.stream().map(name -> {
            Role role = new Role();
            role.setName(name);
            return role;
        }).collect(Collectors.toSet());
    }
}
