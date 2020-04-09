package com.biography.course.service.validators;

import com.biography.course.exception.UrlExistException;
import com.biography.course.model.course.CourseEntity;
import com.biography.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator implements Validator<CourseEntity> {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(final CourseEntity courseEntity) {

        if (existsOtherUrlThisCourse(courseEntity)) {
            throw new UrlExistException("Curso vinculado a URL já existente");
        }

    }

    private boolean existsOtherUrlThisCourse(final CourseEntity courseEntity) {
        return courseRepository.findByUrl(courseEntity.getUrl()).isPresent();
    }
}
