package com.quinbay.march22.SpringWebDependency.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

    @NotNull(message = "Id cannot be null")
    public Long id;
//    public Integer id;

    @NotBlank(message = "First Name should not be null")
    public String name;
//    public String fName;
//    public String lName;
//    public String branch;

    public Student(){

    }

//    public Student(int id, String fName, String lName, String branch){
//        this.id = id;
//        this.fName = fName;
//        this.lName = lName;
//        this.branch = branch;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Long id, String name){
        this.id = id;
        this.name = name;
//        this.fName = fName;
//        this.lName = lName;
//        this.branch = branch;

    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getfName() {
//        return fName;
//    }
//
//    public void setfName(String fName) {
//        this.fName = fName;
//    }
//
//    public String getlName() {
//        return lName;
//    }
//
//    public void setlName(String lName) {
//        this.lName = lName;
//    }
//
//    public String getBranch() {
//        return branch;
//    }
//
//    public void setBranch(String branch) {
//        this.branch = branch;
//    }


}
