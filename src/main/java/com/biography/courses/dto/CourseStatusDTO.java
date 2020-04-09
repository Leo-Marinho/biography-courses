package com.biography.courses.dto;

import com.biography.courses.model.Status;
import com.biography.courses.model.course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseStatusDTO {

    private String name;
    private Status status;

    public CourseStatusDTO(final CourseEntity courseEntity) {
        this.name = courseEntity.getName();
        this.status = courseEntity.getStatus();
    }

}
