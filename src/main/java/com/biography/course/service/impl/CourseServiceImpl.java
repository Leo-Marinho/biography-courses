package com.biography.course.service.impl;

import com.biography.course.dto.CourseDTO;
import com.biography.course.dto.CourseStatusDTO;
import com.biography.course.exception.NotFoundException;
import com.biography.course.exception.StatusCourseInvalidException;
import com.biography.course.model.course.CourseEntity;
import com.biography.course.repository.CourseRepository;
import com.biography.course.service.CourseService;
import com.biography.course.service.validators.Validator;
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
    public List<CourseDTO> searchByName(final String name) {
        log.info("GET=gettingCoursesByName - buscando cursos por nome");

        return courseRepository.findAllByName(name)
                               .orElseThrow(() -> new NotFoundException("Nenhum curso encontrado") )
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

    @Override
    public CourseDTO save(final CourseDTO courseDTO) {
        log.info("POST=creatingNewCourse - criando novo curso");

        courseValidator.validate(courseDTO.toEntity());
        final CourseEntity courseEntity = courseRepository.save(courseDTO.toEntity());

        return courseEntity.toDTO();
    }

    @Override
    public CourseDTO update(final Long id,final CourseDTO courseDTO) {
        log.info("UPDATE=updatingCourse - Atualizando curso");

        courseValidator.validate(courseDTO.toEntity());

        return courseRepository.findById(id)
                               .map(CourseEntity -> CourseEntity.merge(courseDTO))
                               .map(CourseEntity -> courseRepository.save(CourseEntity))
                               .map(CourseDTO::new)
                               .orElseThrow(() -> new NotFoundException("Id Invalido, digite novamente"));
    }

    @Override
    public void deleteById(final Long id) {
        log.info("DELETE=delletingCourseById - Deletando curso");

        final CourseEntity courseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Inexistente - verifique"));

        courseRepository.delete(courseEntity);
    }

}
