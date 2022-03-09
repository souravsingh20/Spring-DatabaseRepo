package com.quinbay.march22.SpringWebDependency.repository;

import com.quinbay.march22.SpringWebDependency.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {
    private String STUDENT_COLLECTION = "student";
    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String, Student> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        this.hashOps = this.redisTemplate.opsForHash();
    }

    public List<Student> getAllStudents() {
        Map<String, Student> allElements = hashOps.entries(STUDENT_COLLECTION);
        return allElements.values().stream().collect(Collectors.toList());
    }

    public Student getStudent(Long StudentId){
        return (Student) hashOps.get(STUDENT_COLLECTION,StudentId);
    }

    public Student addStudent(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(), student);
        return student;
    }

    public Student updateStudent(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(), student);
        return student;
    }

    public void deleteStudent(Long id){
        hashOps.delete(STUDENT_COLLECTION, id);
    }

//    public void updateStudent()

}
