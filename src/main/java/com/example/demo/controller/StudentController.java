package com.example.demo.controller;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/students")


public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<com.example.demo.entity.Student> getById(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }
    

    @PostMapping

    public Student saveOrUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
        return student;
    }


    @DeleteMapping("/{studentId}")
    public void saveOrUpdate(@PathVariable("studentId") Long studentId){
        studentService.delete(studentId);
    }
}
