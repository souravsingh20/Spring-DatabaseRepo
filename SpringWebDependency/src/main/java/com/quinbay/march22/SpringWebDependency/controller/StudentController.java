package com.quinbay.march22.SpringWebDependency.controller;

import com.quinbay.march22.SpringWebDependency.dto.Student;
import com.quinbay.march22.SpringWebDependency.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@Valid
public class StudentController {
    @Autowired
    StudentService studentService;

//    @GetMapping("/student")
//    public List<Student> getAllStudents(){
//        return studentService.getAllStudents();
//    }



//    @GetMapping("/students/{id}")
//    public Student getStudent(@PathVariable(value = "id") Integer id){
//        return studentService.getStudent(id);
//    }

//    @GetMapping("/students")
//    public Student getStudent(@RequestParam(value = "id") Integer id){
//        return studentService.getStudent(id);
//    }

//    @GetMapping("/students")
//    public Student getStudent(@RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "fname", required = false) String name){
//        return studentService.getStudent(id, name);
//    }

//    @PostMapping("/students1")
//    public void addStudent(@RequestBody @Valid Student student){
//
//        studentService.addStudent(student);
//    }

//    @PutMapping("/students2")
//    public void updateStudent(@RequestBody @Valid Student student){
//        studentService.updateStudent(student);
//    }
//
//    @DeleteMapping("/students3")
//    public void deleteStudent(@RequestParam(value = "id") Long id){
//        studentService.deleteStudent(id);
//    }


//    Combining all

    @GetMapping("/student")
    public List<Student> getAllStudents(@RequestParam String db){
        if(db.equals("post"))
            return studentService.getAllPgStudents();
        else if(db.equals("mongo"))
            return studentService.getAllMgStudents();
        else if(db.equals("redis"))
            return studentService.getAllRedisStudents();
        else if(db.equals("list"))
            return studentService.getAllListStudents();
        else
            return studentService.getAllStudents();

    }

    @PostMapping("/students1")
    public void addStudent(@RequestBody @Valid Student student, @RequestParam String db){

        if(db.equals("post"))
            studentService.addPgStudent(student);
        else if(db.equals("mongo"))
            studentService.addMgStudent(student);
        else if(db.equals("redis"))
            studentService.addRedisStudent(student);
        else if(db.equals("list"))
            studentService.addListStudent(student);
    }

    @PutMapping("/students2")
    public void updateStudent(@RequestBody @Valid Student student, @RequestParam String db){

        if(db.equals("post"))
            studentService.updatePgStudent(student);
        else if(db.equals("mongo"))
            studentService.updateMgStudent(student);
        else if(db.equals("redis"))
            studentService.updateRedisStudent(student);
        else if(db.equals("list"))
            studentService.updateListStudent(student);
    }

    @DeleteMapping("/students3")
    public void deleteStudent(@RequestBody Long id, @RequestParam String db){

        if(db.equals("post"))
            studentService.deletePgStudent(id);
        else if(db.equals("mongo"))
            studentService.deleteMgStudent(id);
        else if(db.equals("redis"))
            studentService.deleteRedisStudent(id);
        else if(db.equals("list"))
            studentService.deleteListStudent(id);

    }


}
