package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Course;
import com.efe.okys.okysapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Comparator;

/*
 * Web Programlama – REST API
 * Katmanli Yapi – Controller
 */

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Tüm Dersleri Getir
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Yeni Ders Ekle
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Dersleri Isme Gore Sirala
    @GetMapping("/sorted")
    public List<Course> getCoursesSortedByName() {
        return courseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Course::getName))
                .toList();
    }

    // Dersi Guncelle
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.setCredit(updatedCourse.getCredit());
            course.setInstructorId(updatedCourse.getInstructorId());
            return courseRepository.save(course);
        }).orElse(null);
    }

    // Dersi Sil
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    // Ada Gore Ders Ara
    @GetMapping("/search")
    public List<Course> searchCourseByName(@RequestParam String name) {
        return courseRepository.findByNameContainingIgnoreCase(name);
    }
}
