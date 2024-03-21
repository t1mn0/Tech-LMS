package com.foqs.controller;

import com.foqs.database.entity.Course;
import com.foqs.database.repository.CourseRepository;
import com.foqs.dto.CourseRequestToCreate;
import com.foqs.dto.CourseRequestToUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.requireNonNullElse;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Course createCourse(@Valid @RequestBody CourseRequestToCreate request) {
        Course course = new Course(request.getAuthor(), request.getTitle());
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id,
                             @Valid @RequestBody CourseRequestToUpdate request) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setTitle(request.getTitle());
        course.setAuthor(request.getAuthor());
        courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Course> getCoursesByTitlePrefix(@RequestParam(name = "titlePrefix", required = false) String titlePrefix) {
        return courseRepository.findCoursesByTitleStartingWith(requireNonNullElse(titlePrefix, ""));
    }
}

