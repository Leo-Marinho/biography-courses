package com.biography.courses.resource;

import com.biography.courses.dto.CourseDTO;
import com.biography.courses.dto.CourseResponseStatusDTO;
import com.biography.courses.resource.request.CourseRequest;
import com.biography.courses.service.CourseService;
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
    private List<CourseResponseStatusDTO> searchByStatus(@PathVariable final String status) {

        return courseService.searchByStatus(status);
    }

    @PostMapping
    private CourseDTO createCourse(@Valid @RequestBody final CourseRequest courseRequest) {
        final CourseDTO courseDTO = courseRequest.toDTO();

        return courseService.save(courseDTO);
    }

}