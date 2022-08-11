package com.example.testexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan("com.example.testexercise.config")
public class TestExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestExerciseApplication.class, args);
    }

}
