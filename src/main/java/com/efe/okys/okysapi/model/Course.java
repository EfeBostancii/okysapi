package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Sinif Tanimi
 * Nesne Yonelimli Yapi
 * Veritabani Baglantisi (JPA)
 */

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;

    private int credit;

    private Long instructorId;

    public Course() {}

    public Course(String name, int credit, Long instructorId) {
        this.name = name;
        this.credit = credit;
        this.instructorId = instructorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}
