package com.mongodb.spring.service;

import com.mongodb.spring.document.Gender;
import com.mongodb.spring.document.Student;
import com.mongodb.spring.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findByGender(Gender gender) {
        return studentRepository.findByGender(gender);
    }

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public List<Student> findByGroupId(String groupId) {
        return studentRepository.findByGroupId(groupId);
    }

    public List<Student> findAllOrderByField(String field, boolean ascending) {
        if (ascending) {
            return studentRepository.findAllOrderByFieldAsc(field);
        } else {
            return studentRepository.findAllOrderByFieldDesc(field);
        }
    }
}
