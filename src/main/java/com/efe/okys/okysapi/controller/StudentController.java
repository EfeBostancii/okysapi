package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

/*
 * Web Programlama – REST API
 * J2EE Katmanli Yapi
 * Veri Akisi, JSON Donusu
 */

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Tum Ogrencileri Listele
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Yeni Ogrenci Ekle
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Id Ile Ogrenci Getir
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Ogrenci Sil
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // Ogrenci Guncelle
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setRegistrationDate(updatedStudent.getRegistrationDate());
            return studentRepository.save(student);
        }).orElse(null);
    }

    // Isme Gore Sirala
    @GetMapping("/sorted")
    public List<Student> getStudentsSortedByName() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // Isme Gore Ara
    @GetMapping("/search")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
