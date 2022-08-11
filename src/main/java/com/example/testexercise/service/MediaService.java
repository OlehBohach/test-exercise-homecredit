package com.example.testexercise.service;

import com.example.testexercise.model.Media;
import com.example.testexercise.repository.MediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;

    public Media save(Media media) {
        return mediaRepository.save(media);
    }
}
