package com.biography.courses.service.impl;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.exceptions.StatusNullInvalidException;
import com.biography.courses.model.course.CourseEntity;
import com.biography.courses.repository.CourseRepository;
import com.biography.courses.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> searchAll() {
        log.info("GET=gettingAllCourses - buscando todos os cursos");
        final List<CourseEntity> listCourses = courseRepository.findAll();

        return CourseDTO.listCourseEntityToDTO(listCourses);
    }

    @Override
    public CourseDTO save(final CourseDTO courseDTO) {
        log.info("POST=creatingNewCourse - criando novo curso");

        final CourseEntity courseEntity = courseRepository.save(courseDTO.toEntity());

        return courseEntity.toDTO();
    }


}
