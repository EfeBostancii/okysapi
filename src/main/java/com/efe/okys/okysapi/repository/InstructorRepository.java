package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Katmanli Yapi – Repository
 * JPA Ile Instructor Veri Erisimi
 * Isme Gore Arama Fonksiyonu
 */

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    List<Instructor> findByNameContainingIgnoreCase(String name);
}
