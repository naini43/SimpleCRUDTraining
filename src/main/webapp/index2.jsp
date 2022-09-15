<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList,java.util.Iterator,com.fujitsu.model.Student" %>
<html>
<body>
<h2>Hello index2</h2>
<a href="home">Go to Home Page</a>

<br/><br/>
<%=request.getAttribute("SuccessMsg") %>
<br/><br/>
    <a href="showAddStudent">Add Student</a>
<br/><br/>

    <table border="1">
        <tr>
            <td><b>Id</b></td>
            <td><b>Name</b></td>
            <td><b>Age</b></td>
            <td><b>DOB</b></td>
            <td>ACTION</td>
        </tr>
    <%
        Iterator<Student> iteratorStudent = ((ArrayList<Student>)request.getAttribute("studentlist")).iterator();
        while(iteratorStudent.hasNext()){
            Student st = iteratorStudent.next();
    %>
        <tr>
            <td><%=st.getStudentId()%></td>
            <td><%=st.getStudentName()%></td>
            <td><%=st.getStudentAge()%></td>
            <td><%=st.getStudentDOB()%></td>
            <td></td>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
