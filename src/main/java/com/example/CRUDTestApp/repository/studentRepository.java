package com.example.CRUDTestApp.repository;

import com.example.CRUDTestApp.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student,Long> {

}
