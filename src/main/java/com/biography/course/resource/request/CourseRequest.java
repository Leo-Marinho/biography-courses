package com.biography.course.resource.request;

import com.biography.course.dto.CourseDTO;
import com.biography.course.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {

    private String name;
    private String description;
    private String url;
    private Status status;

    public CourseDTO toDTO(){
        return new CourseDTO(name,description,url,status);
    }
}
