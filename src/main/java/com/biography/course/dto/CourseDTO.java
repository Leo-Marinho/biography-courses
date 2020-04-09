package com.biography.course.dto;

import com.biography.course.model.Status;
import com.biography.course.model.course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private String name;
    private String description;
    private String url;
    private Status status;

    public CourseDTO(final CourseEntity courseEntity) {
        this.name = courseEntity.getName();
        this.description = courseEntity.getDescription();
        this.url = courseEntity.getUrl();
        this.status = courseEntity.getStatus();
    }

    public static List<CourseDTO> listCourseEntityToDTO(final List<CourseEntity> courseEntityList){
        return courseEntityList.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public CourseEntity toEntity() {
        return new CourseEntity(name,description,url,status);
    }

}
