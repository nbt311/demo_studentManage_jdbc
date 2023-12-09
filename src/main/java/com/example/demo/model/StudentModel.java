package com.example.demo.model;

import com.example.demo.database.Database;
import com.example.demo.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentModel implements StudentDAO {
    protected Connection conn;

    public StudentModel(Collection conn) {
        Database database = Database.getInstance();
        this.conn = database.connection();
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dateOfBirth = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classRoom = rs.getString(7);
                Student student = new Student(id,name,email,dateOfBirth,address,phone,classRoom);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student findStudentByID(int id) {
        return null;
    }

    @Override
    public Student findStudentByName(String name) {
        return null;
    }

    @Override
    public void editStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
