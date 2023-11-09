import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    private List<Student> studentList;

    public void init() throws ServletException {
        // Initialize the studentList (you can load data from a database here)
        studentList = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}
