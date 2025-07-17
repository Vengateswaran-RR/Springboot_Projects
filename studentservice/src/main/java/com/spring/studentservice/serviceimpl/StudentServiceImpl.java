package com.spring.studentservice.serviceimpl;

import com.spring.studentservice.StudentService;
import com.spring.studentservice.dto.StudentDto;
import com.spring.studentservice.entity.Student;
import com.spring.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDto getStudentDetails(Long id) {
        return studentRepository.findById(id).map(this::studentDtoMapper).orElse(null);
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentMapper(studentDto);
        Student saveStudent = studentRepository.save(student);
        return studentDtoMapper(saveStudent);
    }

    private StudentDto studentDtoMapper(Student student) {
        return new  StudentDto(
                student.getId(),
                student.getName(),
                student.getDepartment_Name()
        );
    }

    private Student studentMapper(StudentDto studentDto) {
        return new  Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getDepartment_Name()
        );
    }

}
