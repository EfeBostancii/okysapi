package com.efe.okys.okysapi.repository;

import com.efe.okys.okysapi.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Katmanli Yapi – Repository
 * JPA Ile Grade Veri Erisimi
 */

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
