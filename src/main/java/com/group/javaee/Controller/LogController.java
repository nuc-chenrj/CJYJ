package com.group.javaee.Controller;

import com.group.javaee.Mapper.AdminMapper;
import com.group.javaee.Mapper.StudentMapper;
import com.group.javaee.Mapper.TeacherMapper;
import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.Student;
import com.group.javaee.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LogController {
    @Autowired(required = false)
    StudentMapper studentMapper;
    @Autowired(required = false)
    TeacherMapper teacherMapper;
    @Autowired(required = false)
    AdminMapper adminMapper;

    @RequestMapping("/login")
    public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        /**
         *
         * 2019001管理员 000-999
         *
         * 20190001教师 0000-9999
         *
         * 201900001学生 00000-99999
         */
        if(request.getParameter("license").length()==7){
            Admin admin=new Admin();
            admin.setAdminId(Integer.parseInt(request.getParameter("license")));
            admin.setAdminPassword(request.getParameter("password"));

            System.out.println(admin.getAdminId());
            System.out.println(admin.getAdminPassword());
            admin=adminMapper.checkAdmin(admin);

            if(admin!=null){
                HttpSession session=request.getSession();
                session.setAttribute("license",request.getParameter("license"));

                out.println("<script> alert(\"登陆成功!\"); </script>");
                response.setHeader("refresh","1;URL=adminPage");
            }else{
                out.println("<script> alert(\"证件或密码错误!\"); </script>");
                response.setHeader("refresh","1;URL=index");
            }

        }
        else if(request.getParameter("license").length()==8){
            Teacher teacher=new Teacher();
            teacher.setTeacherId(Integer.parseInt(request.getParameter("license")));
            teacher.setTeacherPassword(request.getParameter("password"));
            teacher=teacherMapper.checkTeacher(teacher);

            if(teacher!=null){
                HttpSession session=request.getSession();
                session.setAttribute("license",request.getParameter("license"));
                out.println("<script> alert(\"登陆成功!\"); </script>");
                response.setHeader("refresh","1;URL=teacherPage");
            }else{
                out.println("<script> alert(\"证件或密码错误!\"); </script>");
                response.setHeader("refresh","1;URL=index");
            }

        }
        else if(request.getParameter("license").length()==9){
            Student student=new Student();
            student.setStudentId(Integer.parseInt(request.getParameter("license")));
            student.setStudentPassword(request.getParameter("password"));

            student=studentMapper.checkStudent(student);
            if(student!=null){
                HttpSession session=request.getSession();
                session.setAttribute("license",request.getParameter("license"));

                out.println("<script> alert(\"登陆成功!\"); </script>");
                response.setHeader("refresh","1;URL=studentPage");
            }else{
                out.println("<script> alert(\"证件或密码错误!\"); </script>");
                response.setHeader("refresh","1;URL=index");
            }
        }
        else{
            out.println("<script> alert(\"证件无效!\"); </script>");
            response.setHeader("refresh","1;URL=index");
        }
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        response.setHeader("refresh","1;URL=index");
    }

}
