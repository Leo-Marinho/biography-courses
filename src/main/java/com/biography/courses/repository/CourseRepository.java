package com.biography.courses.repository;

import com.biography.courses.model.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    @Query("SELECT c FROM Course c WHERE LOWER(c.email) = LOWER(:email)")
    Optional<Object> findByUrl(@Param("url") String url);
}
