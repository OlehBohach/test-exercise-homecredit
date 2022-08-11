package com.example.testexercise.repository;

import com.example.testexercise.model.UserRole;
import com.example.testexercise.model.compositeid.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    List<UserRole> findAllByIdRole(String roleName);

    List<UserRole> findAllByIdUser(String id);

    void deleteAllByIdUser(String userId);
}
