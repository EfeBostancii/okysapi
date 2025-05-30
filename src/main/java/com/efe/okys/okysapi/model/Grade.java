package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 *  İlişkisel yapı – Foreign Key var
 *  OOP
 *  JPA Entity
 */

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    private double score;

    public Grade() {}

    public Grade(Enrollment enrollment, double score) {
        this.enrollment = enrollment;
        this.score = score;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
