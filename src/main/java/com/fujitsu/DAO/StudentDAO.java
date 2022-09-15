package com.fujitsu.DAO;

import com.fujitsu.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    //connect to db

    //we want to have a student listing
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public StudentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public ArrayList<Student> getStudentList() throws SQLException{
        ArrayList<Student> stList =  new ArrayList<>();
        String select = "select * from student";

        connect();
        Statement st = jdbcConnection.createStatement();
        ResultSet rs = st.executeQuery(select);

        while(rs.next()){
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentName(rs.getString("student_name"));
            student.setStudentAge(rs.getInt("student_age"));
            student.setStudentDOB(rs.getDate("student_dob"));
            stList.add(student);
        }

        st.close();
        rs.close();
        disconnect();

        return stList;

    }

    public void insertStudent(Student student) throws SQLException {
        connect();

        PreparedStatement ps = jdbcConnection.prepareStatement("INSERT INTO student " +
                " (student_name, student_age) " +
                " VALUES(?,?) ");

        ps.setString(1, student.getStudentName());
        ps.setInt(2, student.getStudentAge());
       // ps.setDate(3, student.getStudentDOB());

        ps.executeUpdate();

        ps.close();
        disconnect();
    }
}
