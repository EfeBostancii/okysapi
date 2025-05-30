package com.efe.okys.okysapi.controller;

import com.efe.okys.okysapi.model.Instructor;
import com.efe.okys.okysapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setName(updatedInstructor.getName());
            instructor.setDepartment(updatedInstructor.getDepartment());
            return instructorRepository.save(instructor);
        }).orElse(null);
    }

    @GetMapping("/sorted")
    public List<Instructor> getSortedInstructors() {
        return instructorRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    @GetMapping("/search")
    public List<Instructor> searchInstructorByName(@RequestParam String name) {
        return instructorRepository.findByNameContainingIgnoreCase(name);
    }

}
