package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * Nesne Yonelimli Yapi
 * Veritabani – JPA Entity
 */

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    private String name;
    private String department;

    public Instructor() {}

    public Instructor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
