package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Grade;
import com.efe.okys.okysapi.repository.EnrollmentRepository;
import com.efe.okys.okysapi.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Web Programlama – REST API
 * JPA Iliskisel Veri Erisimi – Grade JOIN
 * Katmanli Mimari – Controller
 */

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Tum Notlari Getir
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Yeni Not Ekle
    @PostMapping
    public Grade createGrade(@RequestParam Long enrollmentId,
                             @RequestParam double score) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow();
        Grade grade = new Grade(enrollment, score);
        return gradeRepository.save(grade);
    }

    // Not Guncelle
    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestParam double score) {
        return gradeRepository.findById(id).map(g -> {
            g.setScore(score);
            return gradeRepository.save(g);
        }).orElse(null);
    }

    // Not Sil
    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeRepository.deleteById(id);
    }

    // Yuksek Notlari Getir (85+)
    @GetMapping("/highscores")
    public List<Grade> getHighScores() {
        return gradeRepository.findAll()
                .stream()
                .filter(grade -> grade.getScore() >= 85)
                .toList();
    }

    // En Yuksek Notu Getir
    @GetMapping("/topscore")
    public Grade getTopScore() {
        return gradeRepository.findAll()
                .stream()
                .max((g1, g2) -> Double.compare(g1.getScore(), g2.getScore()))
                .orElse(null);
    }
}