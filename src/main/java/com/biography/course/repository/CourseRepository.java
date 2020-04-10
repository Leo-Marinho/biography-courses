package com.biography.course.repository;

import com.biography.course.dto.CourseStatusDTO;
import com.biography.course.model.Status;
import com.biography.course.model.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    @Query("FROM CourseEntity c WHERE c.url = :url")
    Optional<Object> findByUrl(final String url);

    @Query("SELECT c FROM CourseEntity c WHERE c.name LIKE %:name%")
    Optional<List<CourseEntity>> findAllByName(final String name);

    @Query("SELECT new com.biography.course.dto.CourseStatusDTO(c.name, c.status) " +
            " FROM CourseEntity c WHERE c.status = UPPER(:status)")
    List<CourseStatusDTO> findByStatus(final String status);
}

