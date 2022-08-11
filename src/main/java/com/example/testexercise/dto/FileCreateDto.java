package com.example.testexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileCreateDto {
    private String idUser;
    private String name;
    private InputStream content;
}
