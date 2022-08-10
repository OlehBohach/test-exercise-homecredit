package com.example.testexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UserDto {
    private String id;
    private String name;
    private List<String> roleNames;
}
