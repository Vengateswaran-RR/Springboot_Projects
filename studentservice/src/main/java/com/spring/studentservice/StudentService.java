package com.spring.studentservice;

import com.spring.studentservice.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentDto getStudentDetails(Long id);

    StudentDto saveStudent(StudentDto studentDto);

}
