package com.quinbay.march22.SpringWebDependency.service;

import com.quinbay.march22.SpringWebDependency.dto.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getAllListStudents();
    List<Student> getAllPgStudents();
    List<Student> getAllRedisStudents();
    List<Student> getAllMgStudents();

//    Student getStudent(Integer id, String name);

//    void addStudent(Student student);

    void addListStudent(Student student);
    void addPgStudent(Student student);
    void addMgStudent(Student student);
    void addRedisStudent(Student student);

//    Student updateStudent(Student student);

    Student updateListStudent(Student student);
    Student updatePgStudent(Student student);
    Student updateMgStudent(Student student);
    Student updateRedisStudent(Student student);

//    void deleteStudent(Long id);

    void deleteListStudent(Long id);
    void deletePgStudent(Long id);
    void deleteMgStudent(Long id);
    void deleteRedisStudent(Long id);

//    void deleteStudent(Integer id);
}
