package com.example.testexercise.service.mapper;

import com.example.testexercise.dto.UserDto;
import com.example.testexercise.model.Role;
import com.example.testexercise.model.User;
import com.example.testexercise.model.UserRole;
import com.example.testexercise.repository.RoleRepository;
import com.example.testexercise.repository.UserRoleRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {MediaMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRoleRepository userRoleRepository;

    public abstract UserDto toUserDto(User source);

    @AfterMapping
    public UserDto toUserDto(User source, @MappingTarget UserDto dest) {
        List<UserRole> userRoles = userRoleRepository.findAllByIdUser(source.getId());
        List<Role> roles = roleRepository.findAllById(userRoles.stream().map(UserRole::getIdRole).collect(Collectors.toList()));
        List<String> roleNames = roles.stream().map(Role::getName).toList();
        dest.setRoleNames(roleNames);
        return dest;
    }

    public abstract User toUser(UserDto source);

    @AfterMapping
    public User toUser(UserDto source, @MappingTarget User dest) {
        List<Role> existingRoles = roleRepository.findAll();
        List<String> sourceRoles = source.getRoleNames();
        List<Role> destRoles = existingRoles.stream().filter(role -> sourceRoles.contains(role.getName())).toList();
        List<UserRole> userRoles = destRoles.stream().map(r -> {
            UserRole userRole = new UserRole();
            userRole.setIdRole(r.getId());
            return userRole;
        }).toList();
        dest.setUserRoles(userRoles);
        return dest;
    }
}
