package com.example.testexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MediaDto {
    private String id;
    private String path;
    private String name;
    private byte[] content;
}
