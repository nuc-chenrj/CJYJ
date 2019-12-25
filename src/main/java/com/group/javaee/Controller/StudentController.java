package com.group.javaee.Controller;

import com.group.javaee.Mapper.StudentMapper;
import com.group.javaee.Pojo.Student;
import com.group.javaee.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /*2019 12.22 21.03 登陆实现*/
    @RequestMapping("/Login")
    /*@ResponseBody*/
    public String Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        /*        Student student=new Student();
        student.setStudentId(Integer.parseInt(request.getParameter("license")));
        student.setStudentPassword(request.getParameter("password"));

        System.out.println(student.getStudentId());
        System.out.println(student.getStudentPassword());
        System.out.println(studentMapper.checkStudent(student).toString());*/
        PrintWriter out = response.getWriter();
        out.println("<script> alert(\"修改成功!\"); </script>");
        /*response.setHeader("refresh","1;URL=adminPage.jsp");*/
        return "adminPage";
    }

}
