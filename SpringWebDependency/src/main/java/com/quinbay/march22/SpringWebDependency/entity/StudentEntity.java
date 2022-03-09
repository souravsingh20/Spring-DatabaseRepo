package com.quinbay.march22.SpringWebDependency.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Student name cannot be null")
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public StudentEntity(Long id, String name){
//        this.id = id;
//        this.name = name;
//    }
}
