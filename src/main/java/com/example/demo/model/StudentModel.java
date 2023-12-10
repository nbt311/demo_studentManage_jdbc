package com.example.demo.model;

import com.example.demo.database.Database;
import com.example.demo.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentDAO {
    protected Connection conn;

    public StudentModel() {
        Database database = Database.getInstance();
        this.conn = database.connection();
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students";
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
        try {
            String sql ="insert into students\n" +
                    " (name, email, dateOfBirth, address, phone, classRoom)\n" +
                    " values(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3,student.getDateOfBirth());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setString(6,student.getClassRoom());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() +"Error");
        }
    }

    @Override
    public Student findStudentByID(int id) {
        Student student = null;
        try {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dateOfBirth = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classroom = rs.getString(7);
                student = new Student(name, email, dateOfBirth, address,phone,classroom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> findStudentByName(String key) {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"%" + key + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dateOfBirth = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classroom = rs.getString(7);
                Student student = new Student(id,name,email,dateOfBirth,address,phone,classroom);
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return students;
    }

    @Override
    public void editStudent(Student student) {
        try {
            String sql = "UPDATE students SET name = ? , email = ?, dateOfBirth = ?, address = ? , phone = ?, classRoom = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3,student.getDateOfBirth());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setString(6,student.getClassRoom());
            statement.setInt(7,student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int id){
        try {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
    }
}
