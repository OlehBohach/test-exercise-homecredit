package com.example.testexercise.service;

import com.example.testexercise.config.PropertyConfig;
import com.example.testexercise.dto.FileCreateDto;
import com.example.testexercise.model.Media;
import com.example.testexercise.utils.FileUtils;
import com.example.testexercise.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Transactional
@Service
@AllArgsConstructor
public class FileService {
    private final PropertyConfig config;

    @SneakyThrows
    public Media save(FileCreateDto fileCreateDto) {
        String parentDir;
        String childDir;
        parentDir = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        childDir = "avatar";
        Path path = createFileInDirectories(parentDir, childDir, fileCreateDto);
        Media media = new Media(path.toString(), fileCreateDto.getName(), Files.size(path));
        return media;
    }

    private Path createFileInDirectories(String parentName, String childName, FileCreateDto dto) {
        byte[] bytes = FileUtils.getContent(dto.getContent());
        InputStream content = new ByteArrayInputStream(bytes);
        Path parentDir = FileUtils.createDirectoryIfDoesntExist(config.getBasePath(), parentName);
        Path childDir = FileUtils.createDirectoryIfDoesntExist(parentDir.toString(), childName);
        Path result;
        do {
            result = FileUtils.createFile(childDir.toString(), content, StringUtils.getFileName(dto.getName()));
        } while (result == null);
        return result;
    }

}
