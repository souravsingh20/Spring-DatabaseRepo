package com.quinbay.march22.SpringWebDependency.service;

import com.quinbay.march22.SpringWebDependency.dto.Student;
import com.quinbay.march22.SpringWebDependency.entity.StudentEntity;
import com.quinbay.march22.SpringWebDependency.repository.StudentDb;
import com.quinbay.march22.SpringWebDependency.repository.StudentMongoRepository;
import com.quinbay.march22.SpringWebDependency.repository.StudentRedisRepository;
import com.quinbay.march22.SpringWebDependency.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDb studentDb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;


    @Autowired
    StudentMongoRepository studentMongoRepository;


    //Combining All

    @Override
    public List<Student> getAllStudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        for (Student student : studentRedisRepository.getAllStudents()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        for(Student student :studentDb.getStudentList()){
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getAllListStudents(){
        List<Student> s = new ArrayList<>();
        for(Student student :studentDb.getStudentList()){
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getAllMgStudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        return  s;
    }

    @Override
    public List<Student> getAllPgStudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }
        return  s;
    }

    @Override
    public List<Student> getAllRedisStudents() {
        List<Student> s = new ArrayList<>();
        for (Student student : studentRedisRepository.getAllStudents()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setName(student.getName());
            s.add(s1);
        }

        return  s;
    }

    @Override
    public void addListStudent(Student student){
        studentDb.getStudentList().add(new Student (student.getId(),student.getName()));
    }

    @Override
    public void addPgStudent(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentRepository.save(studentEntity);

    }

    @Override
    public void addMgStudent(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentMongoRepository.save(studentEntity);

    }

    @Override
    public void addRedisStudent(Student student){
        studentRedisRepository.addStudent(student);
    }

    @Override
    public Student updateListStudent(Student student){
        for(Student stu:studentDb.getStudentList()){
            if(stu.getId() == student.getId()){
                stu.setName(student.getName());
            }
        }
        return student;
    }

    @Override
    public Student updatePgStudent(Student student){
        Iterable<StudentEntity> studentEntitiyList = studentRepository.findAll();
        for(StudentEntity studentEntity :studentEntitiyList){
           if(studentEntity.getId() == student.getId()){
               studentEntity.setName(student.getName());
               studentRepository.save(studentEntity);
           }
      }
       return student;
    }

    @Override
    public Student updateMgStudent(Student student){
        Iterable<StudentEntity> studentEntitiyList = studentMongoRepository.findAll();
        for(StudentEntity studentEntity :studentEntitiyList){
            if(studentEntity.getId() == student.getId()){
                studentEntity.setName(student.getName());
                studentMongoRepository.save(studentEntity);
            }
        }
        return student;
    }

    @Override
    public Student updateRedisStudent(Student student){
        return studentRedisRepository.updateStudent(student);
    }

    @Override
    public void deleteListStudent(Long id){
        for(Student stu:studentDb.getStudentList()){
            if(stu.getId() == id){
                studentDb.getStudentList().remove(stu);
                break;
            }
        }
    }


    @Override
    public void deletePgStudent(Long id){
        for(StudentEntity studentEntity:studentRepository.findAll()){
            if(studentEntity.getId()==id){
                studentRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public void deleteMgStudent(Long id){
        for(StudentEntity studentEntity:studentMongoRepository.findAll()){
            if(studentEntity.getId()==id){
                studentMongoRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public void deleteRedisStudent(Long id){
        studentRedisRepository.deleteStudent(id);
    }

    // Mongo dependency from here

//    @Override
//    public Student getStudent(Integer id) {
//        Student o = new Student();
//        for (StudentEntity student : studentMongoRepository.findAll()) {
//            if (student.getId() == id) {
//                o.setId(student.getId());
//                o.setName(student.getName());
//                break;
//            }
//        }
//        return o;
//    }

    /*

    @Override
    public void addStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentMongoRepository.save(studentEntity);
    }

    @Override
    public Student updateStudent(Student student) {
        Iterable<StudentEntity> studentEntitiyList = studentMongoRepository.findAll();
        for(StudentEntity studentEntity :studentEntitiyList){
           if(studentEntity.getId() == student.getId()){
               studentEntity.setName(student.getName());
               studentMongoRepository.save(studentEntity);
           }
      }
       return student;
    }

    @Override
    public void deleteStudent(Long id) {
        for(StudentEntity studentEntity:studentMongoRepository.findAll()){
            if(studentEntity.getId()==id){
                studentMongoRepository.deleteById(id);
                break;
            }
        }

    }
    */


//    postgre dependency from here

//    @Override
//    public List<Student> getAllStudents() {
//
////        return studentDb.getStudentList();
//        Iterable<StudentEntity> studentEntitiyList = studentRepository.findAll();
//        List<Student> studentResponseList = new ArrayList<>();
//
//        //convert to response object
//        for(StudentEntity studentEntity : studentEntitiyList){
//            Student student = new Student(studentEntity.getId(),studentEntity.getName());
//            studentResponseList.add(student);
//        }
//        return studentResponseList;
//
//
//    }
//
//    @Override
//    public Student getStudent(Integer id, String name) {
////        for(Student student: studentDb.getStudentList()){
////            if(student.getId() == id || student.getfName().equals(name))
////                return student;
////        }
//        return null;
//    }
//
//    @Override
//    public void deleteStudent(Long id){
//        for(StudentEntity studentEntity:studentRepository.findAll()){
//            if(studentEntity.getId()==id){
//                studentRepository.deleteById(id);
//                break;
//            }
//        }
//    }
//
//
    //    @Override
//    public Student updateStudent(Student student){
//        Iterable<StudentEntity> studentEntitiyList = studentRepository.findAll();
//        for(StudentEntity studentEntity :studentEntitiyList){
//           if(studentEntity.getId() == student.getId()){
//               studentEntity.setName(student.getName());
//               studentRepository.save(studentEntity);
//           }
//      }
//       return student;
//    }


//    list from here

////    @Override
////    public void deleteStudent(Integer id){
//////        for(Student stu:studentDb.getStudentList()){
//////            if(stu.getId() == id){
//////                studentDb.getStudentList().remove(stu);
//////                break;
//////            }
//////        }
////    }
//

//
////    @Override
////    public Student updateStudent(Student student){
//////        for(Student stu:studentDb.getStudentList()){
//////            if(stu.getId() == student.getId()){
//////                stu.setlName(student.getlName());
//////            }
//////        }
//////        return student;
////        return null;
////    }
//
//    public void addStudent(Student student){
//
//        StudentEntity studentEntity=new StudentEntity();
//        studentEntity.setId(student.getId());
//        studentEntity.setName(student.getName());
//        studentRepository.save(studentEntity);
//    }
//
////    @Override
////    public void addStudent(Student student){
//////        studentDb.getStudentList().add(new Student (student.getId(),student.getfName(),student.getlName(),student.getBranch()));
////
////    }



//    Redis from here

//    @Override
//    public List<Student> getAllStudents(){
//        return studentRedisRepository.getAllStudents();
//    }
//
//    @Override
//    public void addStudent(Student student){
//        studentRedisRepository.addStudent(student);
//    }
//
//    @Override
//    public void deleteStudent(Long id){
//        studentRedisRepository.deleteStudent(id);
//    }
//
////    @Override
////    public Student getStudent(Integer id, String student){
////        return  null;
////    }
//
//    @Override
//    public Student updateStudent(Student student){
//        return studentRedisRepository.updateStudent(student);
//    }

//redis ends here

}
