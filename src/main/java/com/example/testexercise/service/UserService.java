package com.example.testexercise.service;

import com.example.testexercise.dto.UserDto;
import com.example.testexercise.model.User;
import com.example.testexercise.model.UserRole;
import com.example.testexercise.model.UserView;
import com.example.testexercise.repository.UserRepository;
import com.example.testexercise.repository.UserRoleRepository;
import com.example.testexercise.repository.UserViewRepository;
import com.example.testexercise.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserViewRepository userViewRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;

    private User get(String userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<UserView> findAllUsers() {
        return userViewRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> findAllAdmins() {
        List<UserRole> userRoles = userRoleRepository.findAllByRoleName("ADMIN");
        List<User> users = userRepository.findAllById(userRoles.stream().map(UserRole::getIdUser).collect(Collectors.toList()));
        return users;
    }

    public void createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void modifyUser(UserDto userDto) {
        User update = userMapper.toUser(userDto);
        User original = get(update.getId());

        original.setName(update.getName());
        original.setRoles(update.getRoles());
        userRepository.save(original);
    }

    public void updateUserAvatar(String userId, MultipartFile file) {

    }

    public void deleteUserByIdHard(String userId) {
        userRepository.deleteById(userId);
    }

    public void deleteUserByIdSoft(String userId) {

    }
}
