<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Add Student</h2>

<form action="/mavenP1/addNewStudent" method="POST">
    Student Name: <input type="text" name="studentNameTxt"/><br/>
    Student Age: <input type="text" name="studentAgeTxt"/><br/>
    <input type="submit"/>
</form>

</body>
</html>