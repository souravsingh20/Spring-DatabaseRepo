package com.quinbay.march22.SpringWebDependency.repository;

import com.quinbay.march22.SpringWebDependency.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data

@Repository
public interface StudentMongoRepository extends MongoRepository<StudentEntity, Long> {
}
