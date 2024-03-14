package com.example.CRUDTestApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private  String studentCourse;

    private String  studentIdNumber;




}
