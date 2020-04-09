package com.biography.courses.service;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.dto.CourseStatusDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> searchAll();

    List<CourseDTO> searchByName(final String name);

    List<CourseStatusDTO> searchByStatus(final String status);

    CourseDTO save(final CourseDTO courseDTO);

    CourseDTO update(final Long id, CourseDTO courseDTO);

    void deleteById(final Long id);

}