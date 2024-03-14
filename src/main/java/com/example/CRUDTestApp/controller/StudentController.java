package com.example.CRUDTestApp.controller;

import com.example.CRUDTestApp.entity.Student;
import com.example.CRUDTestApp.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private StudentRepository studentRepository;

    public ResponseEntity<Student> getAllStudent(){
        try{
            List<Student> studentList= new ArrayList<>();
            studentRepository.findAll().forEach(studentList::add);

            if (studentList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(HttpStatus.OK);


        } catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public void getStudentById(){

    }

    public void addStudent(){

    }

    public void updateStudentById(){

    }

    public void deleteStudent(){

    }




}
