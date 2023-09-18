package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> getAllStudents();
    public ResponseEntity<Student> getONEStudent(Integer id);


}
