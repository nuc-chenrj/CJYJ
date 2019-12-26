package com.group.javaee.Controller;


import com.group.javaee.Mapper.AdminMapper;
import com.group.javaee.Mapper.TeacherMapper;
import com.group.javaee.Pojo.Admin;
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

@Controller
public class AdminController {
    @Autowired(required = false)
    AdminMapper adminMapper;
    @Autowired(required = false)
    TeacherMapper teacherMapper;

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
        String license=request.getSession().getAttribute("license").toString().trim();
        admin.setAdminId(Integer.parseInt(license));
        System.out.println(admin.toString());
        boolean ok = adminMapper.updateAdmin(admin);
        if (ok) {
            out.println("<script> alert(\"修改成功!\"); </script>");
            response.setHeader("refresh","1;URL=adminPage");
        }
        else {
            out.println("<script> alert(\"修改失败!\"); </script>");
            response.setHeader("refresh","1;URL=adminPage");
        }
    }

    @RequestMapping("test")
    @ResponseBody
    Admin test(String searchWay,String searchName){
        Admin admin=teacherMapper.selectAdmin(searchWay,searchName);
        return admin;
    }


    /*测试*/

}
