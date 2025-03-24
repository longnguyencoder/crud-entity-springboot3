package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Role;
import com.example.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}