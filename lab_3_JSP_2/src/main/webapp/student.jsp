<%@page import="java.util.*"%>
<%@page import="sumdu.edu.ua.webstudent.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        h1 {
            text-align: center;
        }
        #page {
            width: 800px;
            margin: auto;
        }
        form {
            width: 400px;
            margin: 20px auto;
        }
        input[type=submit] {
            margin: auto;
        }
        .list, .list td, .list th {
            margin: auto;
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>

<body>
<div id="page">
    <h1>Student Form</h1>
    <form method="post" action="studentAdd">
        <table>
            <tbody>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input id="name" type="text" name="name"></td>
            </tr>
            <tr>
                <td><label for="surname">Surname:</label></td>
                <td><input id="surname" type="text" name="surname"></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input id="email" type="email" name="email"></td>
            </tr>
            </tbody>
        </table>
        <input type="submit" name="send" value="Send">
    </form>

    <%
        List<Student> students = (List<Student>) application.getAttribute("students");
        if (students == null) {
            students = new LinkedList<Student>();
            application.setAttribute("students", students);
        }
        if (request.getParameter("name") != "" || request.getParameter("surname") != "") {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setEmail(request.getParameter("email"));
            students.add(student);
        }
    %>

    <c:if test="${not empty students}">
        <table class="list">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td><c:out value="${s.name}" /></td>
                    <td><c:out value="${s.surname}" /></td>
                    <td><c:out value="${s.email}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
