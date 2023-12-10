package com.example.demo.model;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudent();
    void addStudent(Student student);
    Student findStudentByID(int id);
    List<Student> findStudentByName(String key);
    void editStudent(Student student);

    void deleteStudent(int id);
}
