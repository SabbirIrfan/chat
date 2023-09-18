package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> getONEStudent(Integer id) {
        Optional<Student> entity = studentRepository.findById(id);

        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
