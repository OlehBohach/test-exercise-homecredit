package com.example.testexercise.utils;

import com.example.testexercise.config.PropertyConfig;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StringUtils {

    private final PropertyConfig config;

    private static String DOT;

    @PostConstruct
    private void init() {
        DOT = config.getDelimiter();
    }

    public static String getFileName(@NotNull String filename) {
        String extension;
        String id = UUID.randomUUID().toString();
        int dotIndex = filename.lastIndexOf(DOT);

        if (dotIndex == -1) {
            extension = Strings.EMPTY;
        } else {
            extension = filename.substring(dotIndex);
        }
        return id + extension;
    }
}
