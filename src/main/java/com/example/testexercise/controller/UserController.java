package com.example.testexercise.controller;

import com.example.testexercise.dto.FileCreateDto;
import com.example.testexercise.dto.UserDto;
import com.example.testexercise.model.UserView;
import com.example.testexercise.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/admins")
    public List<UserDto> findAdmins() {
        return userService.findAllAdmins();
    }

    @GetMapping("/all")
    public List<UserView> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @PostMapping("/update")
    public void modifyUser(@RequestBody UserDto userDto) {
        userService.modifyUser(userDto);
    }

    @PostMapping("/{userId}/image")
    @SneakyThrows
    public void changeUserAvatar(@PathVariable String userId, @RequestPart("file") MultipartFile file) {
        userService.updateUserAvatar(FileCreateDto.builder()
                .content(file.getInputStream())
                .idUser(userId)
                .name(file.getResource().getFilename())
                .build());
    }

    @DeleteMapping("/hard/{userId}")
    public void deleteUserByIdHard(@PathVariable String userId) {
        userService.deleteUserByIdHard(userId);
    }

}
