package com.example.testexercise.service;

import com.example.testexercise.model.UserRole;
import com.example.testexercise.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public List<UserRole> findAllById(String id) {
        return userRoleRepository.findAllByIdRole(id);
    }

    public void save(Iterable<UserRole> userRoles) {
        userRoleRepository.saveAll(userRoles);
    }

    public void deleteByUserId(String idUser) {
        userRoleRepository.deleteAllByIdUser(idUser);
    }
}
