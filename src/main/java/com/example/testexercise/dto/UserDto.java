package com.example.testexercise.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;
    private String name;
    private List<String> roleNames;
}
