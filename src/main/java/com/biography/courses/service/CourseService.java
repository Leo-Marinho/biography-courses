package com.biography.courses.service;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.dto.CourseResponseStatusDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> searchAll();

    CourseDTO save(final CourseDTO courseDTO);

    List<CourseDTO> searchByName(final String name);

    List<CourseResponseStatusDTO> searchByStatus(final String status);
}