package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
