package com.example.testexercise.service;

import com.example.testexercise.dto.FileCreateDto;
import com.example.testexercise.dto.UserDto;
import com.example.testexercise.model.Media;
import com.example.testexercise.model.Role;
import com.example.testexercise.model.User;
import com.example.testexercise.model.UserRole;
import com.example.testexercise.model.UserView;
import com.example.testexercise.repository.UserRepository;
import com.example.testexercise.repository.UserViewRepository;
import com.example.testexercise.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserViewRepository userViewRepository;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    private final UserMapper userMapper;
    private final FileService fileService;
    private final MediaService mediaService;

    private User get(String userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<UserView> findAllUsers() {
        return userViewRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAllAdmins() {
        Role role = roleService.findByName("ADMIN");
        List<UserRole> userRoles = userRoleService.findAllById(role.getId());
        List<User> users = userRepository.findAllById(userRoles.stream().map(UserRole::getIdUser).collect(Collectors.toList()));
        List<UserDto> userDtos = users.stream().map(userMapper::toUserDto).collect(Collectors.toList());
        return userDtos;
    }

    public void createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void modifyUser(UserDto userDto) {
        User update = userMapper.toUser(userDto);
        User original = get(update.getId());
        original.setName(update.getName());
        List<UserRole> userRolesToUpdate = update.getUserRoles().stream().peek(r -> r.setIdUser(original.getId())).toList();
        userRoleService.deleteByUserId(original.getId());
        userRoleService.save(userRolesToUpdate);
        userRepository.save(original);
    }

    public void updateUserAvatar(FileCreateDto fileCreateDto) {
        User user = get(fileCreateDto.getIdUser());
        Media media = fileService.save(fileCreateDto);
        media = mediaService.save(media);
        user.setIdMedia(media.getId());
        userRepository.save(user);
    }

    public void deleteUserByIdHard(String userId) {
        userRoleService.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }
}
