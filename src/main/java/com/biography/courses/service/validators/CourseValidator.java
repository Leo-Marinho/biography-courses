package com.biography.courses.service.validators;

import com.biography.courses.exceptions.StatusNullInvalidException;
import com.biography.courses.exceptions.UrlExistEception;
import com.biography.courses.model.course.CourseEntity;
import com.biography.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator implements Validator<CourseEntity> {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(final CourseEntity courseEntity) {

        if(courseEntity.getStatus() == null) {
            throw new StatusNullInvalidException("Selecione um status para o curso");
        }
        if (existsOtherUrlThisCourse(courseEntity)){
            throw new UrlExistEception("Curso vinculado a URL já existente");
        }

    }

    private boolean existsOtherUrlThisCourse(CourseEntity courseEntity) {
        return courseRepository.findByUrl(courseEntity.getUrl()).isPresent();
    }


}
