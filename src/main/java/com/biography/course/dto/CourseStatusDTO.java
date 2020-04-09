package com.biography.course.dto;

import com.biography.course.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseStatusDTO {

    private String name;
    private Status status;

}
