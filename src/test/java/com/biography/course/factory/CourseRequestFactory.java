package com.biography.course.factory;

import com.biography.course.resource.request.CourseRequest;
import org.springframework.stereotype.Component;

import static com.biography.course.model.Status.CONCLUDED;

@Component
public class CourseRequestFactory implements Factory<CourseRequest> {

    @Override
    public CourseRequest createDefault() {
        return CourseRequest.builder()
                .name("Spring Boot")
                .description("Testing course rest api with spring boot ")
                .url("https://cursos.alura.com.br/certificate/9903091d-26cb-4d64-a630-0d1bc26417e7")
                .status(CONCLUDED)
                .build();
    }
}
