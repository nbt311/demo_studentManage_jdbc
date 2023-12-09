package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDAO;
import com.example.demo.model.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    protected StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentModel();
    }
    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentDAO.getAllStudent();
        req.setAttribute("students",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
        dispatcher.forward(req, resp);
    }
    public void showFormAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/addStudent.jsp");
        dispatcher.forward(req, resp);
    }
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String dateOfBirth = req.getParameter("dateOfBirth");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            String classRoom = req.getParameter("classRoom");
            Student student = new Student(name, email, dateOfBirth, address, phone, classRoom);
            studentDAO.addStudent(student);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/addStudent.jsp");
            dispatcher.forward(req,resp);
    }
}
