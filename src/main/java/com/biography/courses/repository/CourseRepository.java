package com.biography.courses.repository;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.dto.CourseResponseStatusDTO;
import com.biography.courses.model.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    @Query("FROM CourseEntity c WHERE c.url = :url")
    Optional<Object> findByUrl(final String url);

    @Query("FROM CourseEntity c WHERE c.name LIKE %:name%")
    Optional<List<CourseDTO>> findAllByName(final String name);

    @Query("SELECT new com.biography.courses.dto.CourseStatusDTO(c.name, c.status) FROM CourseEntity c WHERE c.status = UPPER(:status)")
    List<CourseResponseStatusDTO> findByStatus(final String status);
}

