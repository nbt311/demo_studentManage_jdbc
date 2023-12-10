package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDAO;
import com.example.demo.model.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentController {
    protected StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentModel();
    }
    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        List<Student> students;
        if (key == null) {
            students = studentDAO.getAllStudent();
        }else{
            students = studentDAO.findStudentByName(key);
        }
        req.setAttribute("key",key);
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
    public void showFormEditStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentDAO.findStudentByID(id);
        req.setAttribute("student",student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/editStudent.jsp");
        dispatcher.forward(req,resp);
    }
    public void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String classroom = req.getParameter("classRoom");
        Student student = new Student(id,name,email,dateOfBirth,address,phone,classroom);
        studentDAO.editStudent(student);
        System.out.println(student);
        resp.sendRedirect("/student");
    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentDAO.deleteStudent(id);
        resp.sendRedirect("/student");
    }
}
