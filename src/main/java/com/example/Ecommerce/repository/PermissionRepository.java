package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, String> {
}
