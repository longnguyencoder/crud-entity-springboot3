package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.RoleCreationRequest;
import com.example.Ecommerce.dto.response.RoleResponse;
import com.example.Ecommerce.entity.Permission;
import com.example.Ecommerce.entity.Role;
import com.example.Ecommerce.mapper.RoleMapper;
import com.example.Ecommerce.repository.PermissionRepository;
import com.example.Ecommerce.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    RoleMapper roleMapper;

    public RoleResponse create(RoleCreationRequest request){
        Role role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        Set<Permission> permissionList = new HashSet<>();
        permissions.forEach(permissionList::add);

        role.setPermissions(permissionList);

        return roleMapper.toRoleResponse(
                roleRepository.save(role));
    }

    public List<RoleResponse> getAll(){
        var roles = roleRepository.findAll();
        List<RoleResponse> roleResponses = new ArrayList<>();

        roles.forEach(role ->
                roleResponses.add(
                        roleMapper.toRoleResponse(role)));

        return roleResponses;
    }

    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
