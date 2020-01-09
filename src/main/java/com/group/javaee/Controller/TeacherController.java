package com.group.javaee.Controller;

import com.group.javaee.Mapper.TeacherMapper;
import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.StudentAndGradeAndCourse;
import com.group.javaee.Pojo.Teacher;
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
import java.util.List;
import java.util.ListIterator;

@Controller
public class TeacherController {
    @Autowired(required = false)
    TeacherMapper teacherMapper;

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public void updateTeacher(@Valid @ModelAttribute Teacher teacher, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        model.addAttribute("teacher", teacher);
        String license = request.getSession().getAttribute("license").toString().trim();
        teacher.setTeacherId(Integer.parseInt(license));
        System.out.println(teacher.toString());
        boolean ok = teacherMapper.updateTeacher(teacher);
        if (ok) {
            out.println("<script> alert(\"修改成功!\"); </script>");
            response.setHeader("refresh", "1;URL=teacherPage");
        } else {
            out.println("<script> alert(\"修改失败!\"); </script>");
            response.setHeader("refresh", "1;URL=teacherPage");
        }
        System.out.println(123);
    }

    @RequestMapping(value = "/searchAdmin", method = RequestMethod.POST)
    public void searchAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            String searchway = request.getParameter("searchWay");
            String searchname = request.getParameter("searchName");

            System.out.println(searchway);
            System.out.println(searchname);

            Admin admin = teacherMapper.selectAdmin(searchway, searchname);
            request.setAttribute("admin", admin);

            /*System.out.println(teacher.toString());*/

            request.getRequestDispatcher("/adminSelect").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     */

    @RequestMapping("/gradeManage")
    protected void gradeSelect(HttpServletRequest request, HttpServletResponse response)throws IOException {
        System.out.println(5555);
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        System.out.println(request.getParameter("classID"));

        Integer classId=Integer.parseInt(request.getParameter("classID"));
        try {
            HttpSession session = request.getSession();
            Integer license = Integer.parseInt((String) session.getAttribute("license"));
            System.out.println("license="+license);
            List<StudentAndGradeAndCourse> list = teacherMapper.gradeSelect(license,classId);
            request.setAttribute("StudentAndGradeAndCourseList", list);
            request.getRequestDispatcher("/studentGradeManageDetails").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/saveStudentGrade")
    @ResponseBody
    protected void saveStudentGrade(HttpServletRequest request, HttpServletResponse response)throws IOException {
        /*System.out.println(5555);*/
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        List<StudentAndGradeAndCourse> list = (List<StudentAndGradeAndCourse>) session.getAttribute("StudentAndGradeAndCourseList");

        ListIterator <StudentAndGradeAndCourse> iter= list.listIterator();

        String[] array = request.getParameterValues( "grade");
        for(int i=0;i <array.length;i++) {
            StudentAndGradeAndCourse x = iter.next();
            x.setGrade(Integer.valueOf(array[i]));
            /*System.out.println(x.getGrade());*/
        }
        /**
         * 棒
         */
        System.out.println(list);
        iter= list.listIterator();
        /*System.out.println(iter.next());*/
        for(int i=0;i <array.length;i++){
            StudentAndGradeAndCourse x=iter.next();
            System.out.println(x);
            System.out.println(x.getCourseName());

            Integer courseid=teacherMapper.selectCourseIdByCourseName(x.getCourseName());
            System.out.println(courseid);

            boolean ok=teacherMapper.saveStudentGrade(courseid,x.getStudentId(),x.getGrade());
            if(ok){
                out.println("<script> alert(\"保存成功!\"); </script>");
                response.setHeader("refresh", "1;URL=teacherPage");
            }
            else{
                out.println("<script> alert(\"保存失败!\"); </script>");
                response.setHeader("refresh", "1;URL=teacherPage");
            }
        }

    }
}