package shtonda.controllers;

import shtonda.objects.DAO;
import shtonda.objects.Grade;
import shtonda.objects.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@Controller
public class MainController {
    private final DAO studentDAO = new DAO();
    @GetMapping("/marks")
    public String ShowMarks(@RequestParam(value = "id") Integer id , Model model) throws SQLException {
        List<Grade> grades = studentDAO.FindMarks(id);
        model.addAttribute("students" , studentDAO.FindStudent(id));
        model.addAttribute("marks" , grades);
        return "marks.jsp";
    }
    @GetMapping("/studentadd")
    public String StudentAdd(){
        return "student.jsp";
    }
    @PostMapping("/studentadd")
    public String StudentPost(@ModelAttribute("student")Student student , Model model) throws SQLException {
        studentDAO.AddStudent(student);
        List<Student> students = new LinkedList<Student>();
        students = studentDAO.GetStudents();
        model.addAttribute("students" , students);
        return "student.jsp";
    }

}