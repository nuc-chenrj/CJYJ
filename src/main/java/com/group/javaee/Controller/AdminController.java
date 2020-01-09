package com.group.javaee.Controller;


import com.group.javaee.Mapper.AdminMapper;
import com.group.javaee.Mapper.StudentMapper;
import com.group.javaee.Mapper.TeacherMapper;
import com.group.javaee.Pojo.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

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

        /*System.out.println(admin.toString());*/
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

    @RequestMapping(value = "/warn", method = RequestMethod.POST)
    public void warn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        System.out.println(num);

        List<Integer> list=adminMapper.selectStudentIdByLinkNum(num);
        request.setAttribute("list",list);

        request.getRequestDispatcher("/warnStudentEmail").forward(request, response);

    }

    @RequestMapping(value = "/selectClassesGrade", method = RequestMethod.POST)
    public void selectClassesGrade(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Integer classid= Integer.parseInt(request.getParameter("classID"));
        System.out.println(classid);

        Set<String>courseName= teacherMapper.selectCourseNameByClassesId(classid);
        System.out.println(courseName);

        request.setAttribute("courseName",courseName);

        List<Student>studentList=adminMapper.selectStudentByClassId(classid);
        System.out.println(studentList);
        request.setAttribute("studentList",studentList);

        request.getRequestDispatcher("/adminSelectClassesGradeDetails").forward(request, response);

    }



    @RequestMapping(value = "/AdminSaveStudentGrade", method = RequestMethod.POST)
    public void AdminSaveStudentGrade(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String[] array = request.getParameterValues( "grade");

/*        for (int i=0;i<array.length;i++){
            if(array[i]=="")
                System.out.println(array[i]);
        }*/
        HttpSession session = request.getSession();
        Map<Integer, Integer> ANS= (Map<Integer, Integer>) session.getAttribute("map");
        System.out.println("ANS:"+ANS);

        int i=0;
        for(Integer a:ANS.keySet()){
            Integer studentId=a;
            Integer courseId= ANS.get(a);
            Integer grade=Integer.valueOf(array[i]);
            System.out.println(grade);

            if(array[i].length()==0){
                System.out.println("kong");
                i++;
                continue;
            }

            else{
                System.out.println(studentId);
                System.out.println(courseId);
                System.out.println(grade);
                boolean ok=adminMapper.AdminUpdateStudentGrade(studentId,courseId,grade);
                if(!ok){
                    out.println("<script> alert(\"保存失败!\"); </script>");
                    response.setHeader("refresh", "1;URL=adminPage");
                }
            }
            i++;
        }

        out.println("<script> alert(\"保存成功!\"); </script>");
        response.setHeader("refresh", "1;URL=adminPage");
    }


    @RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
    public void searchCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String searchway = request.getParameter("searchWay");
        String searchname = request.getParameter("searchName");

        Course course = adminMapper.selectCourse(searchway, searchname);
        request.setAttribute("course", course);
        /*System.out.println(course);*/
        //request.setAttribute("course",course);

        request.getRequestDispatcher("AdminCourseSelect").forward(request, response);

/*        out.println("<script> alert(\"保存成功!\"); </script>");
        response.setHeader("refresh", "1;URL=adminPage");*/
    }

}
