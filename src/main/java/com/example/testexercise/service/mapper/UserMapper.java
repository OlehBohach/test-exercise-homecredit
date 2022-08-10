package com.example.testexercise.service.mapper;

import com.example.testexercise.dto.UserDto;
import com.example.testexercise.model.Role;
import com.example.testexercise.model.User;
import com.example.testexercise.repository.RoleRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    public RoleRepository roleRepository;

    public abstract UserDto toUserDto(User source);

    public abstract User toUser(UserDto source);

    @AfterMapping
    public User toUser(UserDto source, @MappingTarget User dest) {
        List<Role> existingRoles = roleRepository.findAll();
        List<String> sourceRoles = source.getRoleNames();
        List<Role> destRoles = existingRoles.stream().filter(role -> sourceRoles.contains(role.getName())).collect(Collectors.toList());
        dest.setRoles(destRoles);
        return dest;
    }
}
