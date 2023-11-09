package sumdu.edu.ua.webstudent;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        if (students == null) {
            students = new LinkedList<Student>();
            getServletContext().setAttribute("students", students);
        }
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        if (name != null && !name.isEmpty() && surname != null && !surname.isEmpty()) {
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setEmail(email);
            students.add(student);
        }
        response.sendRedirect("student.jsp");
    }
}
