package com.example.testexercise.repository;

import com.example.testexercise.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, String> {
}
