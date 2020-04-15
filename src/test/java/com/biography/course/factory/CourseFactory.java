package com.biography.course.factory;

import com.biography.course.model.course.CourseEntity;
import org.springframework.stereotype.Component;

import static com.biography.course.model.Status.CONCLUDED;


@Component
public class CourseFactory implements Factory<CourseEntity> {

    @Override
    public CourseEntity createDefault() {
        return CourseEntity.builder()
                .name("Rest Assured")
                .description("Testing course rest api with rest assured ")
                .url("https://cursos.alura.com.br/user/leomarinho-is/casdadaourse/rest-assured/certificate")
                .status(CONCLUDED)
                .build();
    }



}
