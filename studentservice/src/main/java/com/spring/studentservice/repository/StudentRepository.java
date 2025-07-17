package com.spring.studentservice.repository;

import com.spring.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findById(Long id);

    @Query(value = "select * from student where Name = :name",nativeQuery = true) //Regular SQL
    String findByName(String name);

    @Query(value = "select s.id from Student s where s.department_Name = ?1") //JQL
   // @Query(value = "select s from Student s where s.department_Name = ?1") //JQL
    String findByDepartmentName(String departmentName);
}
