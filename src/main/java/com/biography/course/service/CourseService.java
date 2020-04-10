package com.biography.course.service;

import com.biography.course.dto.CourseDTO;
import com.biography.course.dto.CourseStatusDTO;
import com.biography.course.model.Status;

import java.util.List;

public interface CourseService {

    List<CourseDTO> searchAll();

    List<CourseDTO> searchByName(final String name);

    List<CourseStatusDTO> searchByStatus(final String status);

    CourseDTO save(final CourseDTO courseDTO);

    CourseDTO update(final Long id, CourseDTO courseDTO);

    void deleteById(final Long id);

}