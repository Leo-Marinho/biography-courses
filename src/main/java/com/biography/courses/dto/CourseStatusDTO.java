package com.biography.courses.dto;

import com.biography.courses.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseStatusDTO {

    private String name;
    private Status status;
}
