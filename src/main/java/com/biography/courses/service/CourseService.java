package com.biography.courses.service;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.model.course.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseDTO> searchAll();

    CourseDTO save(final CourseDTO courseDTO);

    List<CourseDTO> searchByName(String name);
}