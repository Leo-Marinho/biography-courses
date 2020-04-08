package com.biography.courses.service.validators;

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

        if (existsOtherUrlThisCourse(courseEntity)){
            throw new UrlExistEception("Url já existente");
        }

    }

    private boolean existsOtherUrlThisCourse(CourseEntity courseEntity) {
        return courseRepository.findByUrl(courseEntity.getUrl()).isPresent();
    }
}
