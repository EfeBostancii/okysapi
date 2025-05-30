package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Katmanli Yapi – Repository
 * JPA Ile Course Veri Erisimi
 * Isme Gore Arama Fonksiyonu
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContainingIgnoreCase(String name);
}
