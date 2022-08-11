package com.example.testexercise.service.mapper;

import com.example.testexercise.dto.MediaDto;
import com.example.testexercise.model.Media;
import com.example.testexercise.utils.FileUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {FileUtils.class})
public abstract class MediaMapper {

    @Mapping(target = "content", expression = "java(FileUtils.getFileContent(source))")
    public abstract MediaDto toDto(Media source);

    public abstract Media toMedia(MediaDto source);
}
