package com.example.testexercise.utils;

import com.example.testexercise.model.Media;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.nonNull;

@UtilityClass
public class FileUtils {

    @SneakyThrows
    public static Path createDirectoryIfDoesntExist(String path, String directoryName) {
        String fullPath = path.endsWith(java.io.File.separator)
                ? path + directoryName
                : path + java.io.File.separator + directoryName;
        if (!Files.exists(Paths.get(fullPath))) {
            return Files.createDirectories(Paths.get(fullPath));
        }
        return Paths.get(fullPath);
    }

    @SneakyThrows
    public Path createFile(String directoryPath, InputStream content, String fileName) {
        String filePath = directoryPath + java.io.File.separator + fileName;
        if (Files.exists(Paths.get(filePath))) {
            return null;
        }

        java.io.File file = new java.io.File(filePath);
        file.getParentFile().mkdirs();
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            StreamUtils.writeToOutputStream(content, outputStream);
        }
        return file.toPath();
    }

    @SneakyThrows
    public byte[] getFileContent(Media media) {
        return Files.readAllBytes(Paths.get(media.getPath()));
    }

    @SneakyThrows
    public static byte[] getContent(InputStream content) {
        var bytes = new byte[]{};
        if (nonNull(content)) {
            bytes = content.readAllBytes();
        }
        return bytes;
    }
}
