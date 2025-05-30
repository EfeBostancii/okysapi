package com.efe.okys.okysapi.model;

import jakarta.persistence.*;

/*
 * OOP (Class, Encapsulation)
 * Veritabani Baglantisi (JPA)
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;

    @Column(unique = true)
    private String email;

    private String registrationDate;

    // Constructor
    public Student() {}

    public Student(String name, String email, String registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // Getter - Setter
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
