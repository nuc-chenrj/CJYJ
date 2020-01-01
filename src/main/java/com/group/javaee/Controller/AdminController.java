package com.group.javaee.Controller;


import com.group.javaee.Mapper.AdminMapper;
import com.group.javaee.Mapper.StudentMapper;
import com.group.javaee.Mapper.TeacherMapper;
import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.Course;
import com.group.javaee.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired(required = false)
    AdminMapper adminMapper;
    @Autowired(required = false)
    TeacherMapper teacherMapper;
    @Autowired(required = false)
    StudentMapper studentMapper;

    @RequestMapping(value = "/{X}")
    public String dir(@PathVariable String X, Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return X;
    }

/*    @RequestMapping(value = "/{X}")
    public String dir(@PathVariable String X) {
        return X;
    }*/

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public void updateAdmin(@Valid @ModelAttribute Admin admin, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        model.addAttribute("admin", admin);
        String license = request.getSession().getAttribute("license").toString().trim();
        admin.setAdminId(Integer.parseInt(license));
        System.out.println(admin.toString());
        boolean ok = adminMapper.updateAdmin(admin);
        if (ok) {
            out.println("<script> alert(\"修改成功!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        } else {
            out.println("<script> alert(\"修改失败!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        }
    }

/*    @RequestMapping("test")
    @ResponseBody
    Admin test(String searchWay,String searchName){
        Admin admin=teacherMapper.selectAdmin(searchWay,searchName);
        return admin;
    }*/

/*
    @RequestMapping("test")
    @ResponseBody
    Teacher test(String searchWay,String searchName){
        Teacher teacher= studentMapper.selectTeacher(searchWay,searchName);
        return teacher;
    }
*/

/*    @RequestMapping("test")
    @ResponseBody
    List<Integer> test(int id) {
        return teacherMapper.selectClassId(id);
    }*/

/*    @RequestMapping("test")
    @ResponseBody
    Set<String> test(int id) {
        return teacherMapper.selectCourseNameByClassesId(id);
    }*/

/*    @RequestMapping("test")
    @ResponseBody
    String test() {
        return "yes";
    }*/


    @RequestMapping(value = "/insertTeacher", method = RequestMethod.POST)
    public void insertTeacher(@Valid @ModelAttribute Teacher teacher, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        model.addAttribute("teacher", teacher);
        String license = request.getSession().getAttribute("license").toString().trim();
        teacher.setTeacherId(Integer.parseInt(license));
        System.out.println(teacher.toString());

        boolean ok = adminMapper.insertTeacher(teacher);
        if (ok) {
            out.println("<script> alert(\"插入成功!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        } else {
            out.println("<script> alert(\"插入失败!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        }
    }

    @RequestMapping(value = "/insertCourse", method = RequestMethod.POST)
    public void insertCourse(@Valid @ModelAttribute Course course, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        model.addAttribute("course", course);

        boolean ok = adminMapper.insertCourse(course);
        if (ok) {
            out.println("<script> alert(\"插入成功!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        } else {
            out.println("<script> alert(\"插入失败!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        }
    }


/*    @RequestMapping("/testController")
    @ResponseBody
    String test() {
        return "test";
    }*/

    @RequestMapping("/deleteTeacher")
    public void deleteTeacher(@Valid @ModelAttribute Admin admin, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        int teacherID = Integer.parseInt(request.getParameter("ID"));
        System.out.println(teacherID);

        boolean ok = adminMapper.deleteTeacher(teacherID);
        if (ok) {
            out.println("<script> alert(\"删除成功!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        } else {
            out.println("<script> alert(\"删除失败!\"); </script>");
            response.setHeader("refresh", "1;URL=adminPage");
        }
    }
}
