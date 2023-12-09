package com.example.demo.model;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudent();
    void addStudent(Student student);
    Student findStudentByID(int id);
    Student findStudentByName(String name);
    void editStudent(Student student);
    void deleteStudent(Student student);
}
