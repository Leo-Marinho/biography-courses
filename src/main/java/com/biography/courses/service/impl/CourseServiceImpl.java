package com.biography.courses.service.impl;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.dto.CourseStatusDTO;
import com.biography.courses.exceptions.NoCoursesFoundWithThisNameException;
import com.biography.courses.exceptions.StatusCourseInvalidException;
import com.biography.courses.model.course.CourseEntity;
import com.biography.courses.repository.CourseRepository;
import com.biography.courses.service.CourseService;
import com.biography.courses.service.validators.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Validator<CourseEntity> courseValidator;

    @Override
    public List<CourseDTO> searchAll() {
        log.info("GET=gettingAllCourses - buscando todos os cursos");
        final List<CourseEntity> listCourses = courseRepository.findAll();

        return CourseDTO.listCourseEntityToDTO(listCourses);
    }

    @Override
    public CourseDTO save(final CourseDTO courseDTO) {
        log.info("POST=creatingNewCourse - criando novo curso");

        courseValidator.validate(courseDTO.toEntity());
        final CourseEntity courseEntity = courseRepository.save(courseDTO.toEntity());

        return courseEntity.toDTO();
    }

    @Override
    public List<CourseDTO> searchByName(final String name) {
        log.info("GET=gettingCoursesByName - buscando cursos por nome");

        return courseRepository.findAllByName(name)
                               .orElseThrow(() -> new NoCoursesFoundWithThisNameException("Nenhum curso encontrado") )
                               .stream()
                               .map(CourseDTO::new)
                               .collect(Collectors.toList());
    }

    @Override
    public List<CourseStatusDTO> searchByStatus(final String status) {
        log.info("GET=gettingCourseByStatus - buscando cursos por status");

        if (courseRepository.findByStatus(status).isEmpty()) {
            throw new StatusCourseInvalidException("Não encontramos cursos com esse status");
        }

        return courseRepository.findByStatus(status);
    }

}
