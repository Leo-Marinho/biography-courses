package com.biography.course.factory;

import com.biography.course.model.Status;
import com.biography.course.resource.request.CourseRequest;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory implements Factory<CourseRequest> {

    @Override
    public CourseRequest createDefault() {
        return CourseRequest.builder()
                            .name("Rest Assured")
                            .description("Testing course rest api with rest assured ")
                            .url("https://cursos.alura.com.br/user/leomarinho-is/course/rest-assured/certificate")
                            .status(Status.CONCLUDED)
                            .build();
    }
}
