package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.repository.StudentRepository;
import com.irfancodes.chat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getEntityById(@PathVariable Integer id) {
        return studentService.getONEStudent(id);
    }

}
