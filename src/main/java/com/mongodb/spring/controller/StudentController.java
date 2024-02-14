package com.mongodb.spring.controller;

import com.mongodb.spring.document.Gender;
import com.mongodb.spring.document.Student;
import com.mongodb.spring.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Student>> findByGender(@PathVariable Gender gender) {
        List<Student> students = studentService.findByGender(gender);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Student>> findAll(Pageable pageable) {
        Page<Student> students = studentService.findAll(pageable);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Student>> findByGroupId(@PathVariable String groupId) {
        List<Student> students = studentService.findByGroupId(groupId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Student>> findAllOrderByField(@RequestParam String field, @RequestParam boolean ascending) {
        List<Student> students = studentService.findAllOrderByField(field, ascending);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
