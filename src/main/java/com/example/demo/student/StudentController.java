package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentServices studnetServices;

    @Autowired
    public StudentController(StudentServices studnetServices) {
        this.studnetServices = studnetServices;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studnetServices.getStudents();
    }

    @PostMapping
    public void registerantionStudent(@RequestBody Student student) {
        studnetServices.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studnetServices.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studnetServices.updateStudent(studentId, name, email);
    }
}
