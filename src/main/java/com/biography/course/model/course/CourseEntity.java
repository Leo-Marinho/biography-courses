package com.biography.course.model.course;

import com.biography.course.dto.CourseDTO;
import com.biography.course.model.Status;
import com.biography.course.resource.request.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is require")
    @NotBlank(message = "name is require")
    @NotEmpty(message = "name is require")
    @Size(min = 3, max = 50)
    private String name;

    @NotNull(message = "description is require")
    @NotBlank(message = "description is require")
    @NotEmpty(message = "description is require")
    @Size(min = 10, max = 200)
    private String description;

    @NotNull(message = "description is require")
    @NotBlank(message = "description is require")
    @NotEmpty(message = "description is require")
    @Size(min = 10, max = 150)
    private String url;

    @Enumerated(STRING)
    @NotNull(message = "status is require")
    private Status status;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date dateUpdated;

    public CourseEntity(final String name, final String description, final String url, final Status status) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.status = status;
    }

    public CourseDTO toCourseDTO() {
        return new CourseDTO(name, description, url, status);
    }

    public CourseEntity merge(final CourseDTO courseDTO) {
        this.name = courseDTO.getName();
        this.description = courseDTO.getDescription();
        this.url = courseDTO.getUrl();
        this.status = courseDTO.getStatus();

        return this;
    }
}
