package com.group.javaee.Controller;

import com.group.javaee.Mapper.StudentMapper;
import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.Student;
import com.group.javaee.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class StudentController {
    @Autowired(required = false)
    LoginService loginService;
    @Autowired(required = false)
    StudentMapper studentMapper;

    @RequestMapping("/index")
    public String page(){
        return "index";
    }


    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public void updateStudent(@Valid @ModelAttribute Student student, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        model.addAttribute("student", student);
        String license = request.getSession().getAttribute("license").toString().trim();
        student.setStudentId(Integer.parseInt(license));
        System.out.println(student.toString());
        boolean ok = studentMapper.updateStudent(student);
        if (ok) {
            out.println("<script> alert(\"修改成功!\"); </script>");
            response.setHeader("refresh", "1;URL=studentPage");
        } else {
            out.println("<script> alert(\"修改失败!\"); </script>");
            response.setHeader("refresh", "1;URL=studentPage");
        }
        System.out.println(123);
    }


}
