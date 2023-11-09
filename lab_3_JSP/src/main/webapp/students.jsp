<%@ page import="Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
<h1>Student List</h1>

<ul>
    <c:forEach items="${studentList}" var="student">
        <li>${student.name} ${student.surname} - ${student.email}</li>
    </c:forEach>
</ul>
</body>
</html>
