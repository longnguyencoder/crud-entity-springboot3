package com.example.Ecommerce.mapper;


import com.example.Ecommerce.dto.request.RoleCreationRequest;
import com.example.Ecommerce.dto.response.RoleResponse;
import com.example.Ecommerce.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleCreationRequest request);

    RoleResponse toRoleResponse(Role entity);
}

