package com.spring.studentservice.controller;

import com.spring.studentservice.StudentService;
import com.spring.studentservice.dto.StudentDto;
import com.spring.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public StudentDto getStudentsById(@PathVariable Long id){
        return studentService.getStudentDetails(id);
    }

    @PostMapping
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }
}
