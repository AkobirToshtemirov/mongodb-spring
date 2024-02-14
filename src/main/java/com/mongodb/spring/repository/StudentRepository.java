package com.mongodb.spring.repository;

import com.mongodb.spring.document.Gender;
import com.mongodb.spring.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{ 'gender' : ?0 }")
    List<Student> findByGender(Gender gender);

    @Query("{ 'group.id' : ?0 }")
    List<Student> findByGroupId(String groupId);

    @Query(value = "{}", sort = "{ ?0 : 1 }")
    List<Student> findAllOrderByFieldAsc(String field);

    @Query(value = "{}", sort = "{ ?0 : -1 }")
    List<Student> findAllOrderByFieldDesc(String field);
}