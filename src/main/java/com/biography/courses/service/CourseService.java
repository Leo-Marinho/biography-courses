package com.biography.courses.service;

import com.biography.courses.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> searchAll();

    CourseDTO save(final CourseDTO courseDTO);
}