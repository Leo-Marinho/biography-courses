package com.biography.courses.model.course;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.model.Status;
import lombok.AllArgsConstructor;
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

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @NotEmpty @Size(min = 3, max = 50 )
    private String name;

    @NotNull @NotBlank @NotEmpty @Size(min = 10, max = 200 )
    private String description;

    @NotNull @NotBlank @NotEmpty @Size(min = 10, max = 150 )
    private String url;

    @Enumerated(EnumType.STRING) @NotNull
    private Status status;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date dateUpdated;

    public CourseEntity(final String name, final String description, final String url,final Status status) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.status = status;
    }

    public CourseDTO toDTO() {
        return new CourseDTO(name,description,url,status);
    }
}
