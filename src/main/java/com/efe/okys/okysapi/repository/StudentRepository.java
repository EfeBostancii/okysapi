package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Katmanli Yapi – Repository
 * Veritabani Baglantisi (MSSQL)
 * JPA Ile Student Veri Erisimi
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String name);
}
