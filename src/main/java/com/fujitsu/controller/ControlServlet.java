package com.fujitsu.controller;

import com.fujitsu.DAO.StudentDAO;
import com.fujitsu.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ControlServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        studentDAO = new StudentDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        String action = req.getServletPath();

        if(action != null && action.equals("/home")){
            resp.sendRedirect("home.jsp");
        } else if(action != null && action.equals("/showAddStudent")) {
            resp.sendRedirect("addStudent.jsp");
        }else if(action != null && action.equals("/addNewStudent")){
            addStudent(req, resp);
        }
        else{
            //resp.sendRedirect("index2.jsp");
            listOutStudent(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String str = "26-09-2011";
        String name = req.getParameter("studentNameTxt");
        int age = Integer.parseInt(req.getParameter("studentAgeTxt"));
        //Date dt = Date.valueOf(str);

        Student student = new Student(name,age);

        try {
            studentDAO.insertStudent(student);

            req.setAttribute("SuccessMsg", "Successfully insert a new student");
            listOutStudent(req, resp);

        }catch(SQLException sqle){
            req.setAttribute("error", sqle.getMessage());

            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req,resp);
        }

    }

    public void listOutStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        try {
            ArrayList<Student> stList = studentDAO.getStudentList();
            req.setAttribute("studentlist", stList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("index2.jsp");
            dispatcher.forward(req,resp);

        }catch(SQLException sqle){
            req.setAttribute("error", sqle.getMessage());

            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
