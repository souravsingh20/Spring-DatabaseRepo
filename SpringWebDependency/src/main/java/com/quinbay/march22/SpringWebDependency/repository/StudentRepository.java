package com.quinbay.march22.SpringWebDependency.repository;

import com.quinbay.march22.SpringWebDependency.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {


}
