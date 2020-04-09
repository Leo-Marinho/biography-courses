package com.biography.course.resource;

import com.biography.course.dto.CourseDTO;
import com.biography.course.dto.CourseStatusDTO;
import com.biography.course.resource.request.CourseRequest;
import com.biography.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @GetMapping
    private List<CourseDTO> searchAll() {
        return courseService.searchAll();
    }

    @GetMapping("/{name}")
    private List<CourseDTO> searchByName(@PathVariable final String name){

        return courseService.searchByName(name);
    }

    @GetMapping("/status/{status}")
    private List<CourseStatusDTO> searchByStatus(@PathVariable final String status) {

        return courseService.searchByStatus(status);
    }

    @PostMapping
    private CourseDTO createCourse(@Valid @RequestBody final CourseRequest courseRequest) {
        final CourseDTO courseDTO = courseRequest.toDTO();

        return courseService.save(courseDTO);
    }

    @PutMapping("/{id}")
    private CourseDTO updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest courseRequest){

        final CourseDTO courseDTO = courseRequest.toDTO();

        return courseService.update(id,courseDTO);
    }

    @DeleteMapping("/{id}")
    private void deleteByid(@PathVariable Long id){

        courseService.deleteById(id);
    }

}