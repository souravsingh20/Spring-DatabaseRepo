package com.quinbay.march22.SpringWebDependency.repository;

import com.quinbay.march22.SpringWebDependency.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //or @Repository
public class StudentDb {
    private List<Student> myStudentList = new ArrayList<>();
    public List<Student> getStudentList(){

        if(myStudentList.size() == 0) {

//            Student s1 = new Student(1, "Sourav1", "Singh1", "Cse");
//            Student s2 = new Student(2, "Sourav2", "Singh2", "Civil");
//            Student s3 = new Student(3, "Sourav3", "Singh3", "Ece");
//            Student s4 = new Student(4, "Sourav4", "Singh4", "Mech");
//            Student s5 = new Student(5, "Sourav5", "Singh5", "EEE");

            Student s1 = new Student(1L, "Sourav Singh1");
            Student s2 = new Student(2L, "Sourav Singh2");
            Student s3 = new Student(3L, "Sourav Singh3");
            Student s4 = new Student(4L, "Sourav Singh4");
            Student s5 = new Student(5L, "Sourav Singh5");


            myStudentList.add(s1);
            myStudentList.add(s2);
            myStudentList.add(s3);
            myStudentList.add(s4);
            myStudentList.add(s5);

        }

        return  myStudentList;
    }
}
