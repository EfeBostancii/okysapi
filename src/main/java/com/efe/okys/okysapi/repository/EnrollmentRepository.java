package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Enrollment;
import com.efe.okys.okysapi.model.Student;
import com.efe.okys.okysapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * JPA Repository Arayuzu
 * Iliskisel Veri Erisimi
 * Student-Course Arasi Kayıt Islemleri
 */

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    boolean existsByStudentAndCourse(Student student, Course course);

    List<Enrollment> findByStudent(Student student);

    List<Enrollment> findByCourse(Course course);
}
