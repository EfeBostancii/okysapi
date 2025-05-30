package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Course;
import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.repository.CourseRepository;
import com.efe.okys.okysapi.repository.EnrollmentRepository;
import com.efe.okys.okysapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Web Programlama – REST API
 * JPA Iliskisel Veri Erisimi – Enrollment JOIN
 * Katmanli Yapi – Controller
 */

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Tum Kayitlari Getir
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Yeni Kayit Olustur
    @PostMapping
    public Enrollment createEnrollment(@RequestParam Long studentId,
                                       @RequestParam Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        boolean exists = enrollmentRepository.existsByStudentAndCourse(student, course);
        if (exists) {
            throw new RuntimeException("Bu öğrenci bu kursa zaten kayıtlı.");
        }

        Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
        return enrollmentRepository.save(enrollment);
    }

    // Kayit Sil - Id Ile
    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentRepository.deleteById(id);
    }

    // Oğrenciye Gore Kayitlar
    @GetMapping("/by-student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return enrollmentRepository.findByStudent(student);
    }

    // Kursa Gpre Kayit
    @GetMapping("/by-course/{courseId}")
    public List<Enrollment> getByCourse(@PathVariable Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        return enrollmentRepository.findByCourse(course);
    }
}
