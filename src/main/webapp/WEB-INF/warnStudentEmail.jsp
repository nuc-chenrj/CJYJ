<%@ page import="com.group.javaee.Pojo.Admin" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.group.javaee.Mapper.TeacherMapper" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.group.javaee.Mapper.AdminMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="com.group.javaee.Pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: wan14
  Date: 2019/12/22
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="baidu-site-verification" content="UW1SBiMHO7"/>
    <meta name="google-site-verification" content="YTgbOq_0TDShJS6KTcUYCQoAAZTm308SJ7ibsafBD_Y"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>学生成绩预警系统</title>

    <link rel="shortcut icon" type="image/png" href="https://cdn.acwing.com/static/web/img/favicon.ico"/>
    <link rel="stylesheet" href="https://cdn.acwing.com/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.acwing.com/static/web/css/signform.css">
    <link rel="stylesheet" href="https://cdn.acwing.com/static/jquery-ui-dist/jquery-ui.min.css">

    <script src="https://cdn.acwing.com/static/jquery/js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.acwing.com/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.acwing.com/static/web/css/style.css">
    <link rel="stylesheet" href="https://cdn.acwing.com/static/web/css/about/homepage.css"/>

    <style>
        /* latin-ext */
        .center-banner {
            background-image: linear-gradient(rgba(206, 27, 40, 0.25), rgba(206, 27, 40, 0.25)), url("https://cdn.acwing.com/static/web/img/homepage/cta01.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }
    </style>
</head>

<body id="acwing_body">
<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Header -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#topNavBar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">学生成绩预警系统</a>
        </div>

        <!-- Items -->
        <div class="collapse navbar-collapse" id="topNavBar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">首页</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        教师管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="AdminTeacherSelect">教师查询</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#addTeacher-modal">教师录入</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        学生管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#borrow-modal">学生成绩查询</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#borrow-modal">班级成绩查询</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#add-modal">预警学生查询</a></li>
                    </ul>
                </li>


                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        课程管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#borrow-modal">课程查询</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#addCourse-modal">课程录入</a></li>
                    </ul>
                </li>
                <li><a href="#" data-toggle="modal" data-target="#update-modal">查看/修改个人信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/user/myspace/notification/1/">
                        <span class="glyphicon glyphicon-bell" style="font-size: 20px;"></span>
                    </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <strong id="id_user_username"><%=session.getAttribute("license")%>
                        </strong>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">登出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="modal fade" id="addTeacher-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true"
     style="display: none;">
    <div class="modal-dialog" style="width: 85%; max-width: 350px;">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
                <span class="acwing-brand">成绩预警系统</span>
            </div>
            <!-- Begin # DIV Form -->
            <div id="div-forms">
                <!-- Begin # Login Form -->
                <form class="sign-form" role="form" modelAttribute="teacher" action="/insertTeacher" method="post">
                    <input type='hidden' name='csrfmiddlewaretoken'
                           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
                    <div class="modal-body">
                        <div id="div-login-msg">
                            <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                            <span id="text-login-msg">录入信息</span>
                        </div>
                        <input name="teacherName" class="form-control" type="text" placeholder="姓名" maxlength="30">
                        <input name="teacherPassword" class="form-control" type="text" placeholder="密码" maxlength="30">
                        <input name="teacherEmail" class="form-control" type="email" placeholder="邮箱" maxlength="16">
                        <input name="teacherTel" class="form-control" type="tex" placeholder="电话" maxlength="16">
                    </div>

                    <div class="modal-footer">
                        <div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
                        </div>
                    </div>
                </form>
                <!-- End # Login Form -->
            </div>
            <!-- End # DIV Form -->
        </div>
    </div>
</div>

<div class="modal fade" id="addCourse-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true"
     style="display: none;">
    <div class="modal-dialog" style="width: 85%; max-width: 350px;">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
                <span class="acwing-brand">成绩预警系统</span>
            </div>
            <!-- Begin # DIV Form -->
            <div>
                <!-- Begin # Login Form -->
                <form class="sign-form" role="form" modelAttribute="course" action="/insertCourse" method="post">
                    <input type='hidden' name='csrfmiddlewaretoken'
                           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
                    <div class="modal-body">
                        <div>
                            <div class="glyphicon glyphicon-chevron-right"></div>
                            <span>录入信息</span>
                        </div>
                        <input name="courseName" class="form-control" type="text" placeholder="课程名" maxlength="30">
                        <input name="method" class="form-control" type="text" placeholder="考试类型" maxlength="30">
                    </div>

                    <div class="modal-footer">
                        <div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
                        </div>
                    </div>
                </form>
                <!-- End # Login Form -->
            </div>
            <!-- End # DIV Form -->
        </div>
    </div>
</div>
<%
    Integer license = Integer.parseInt((String) session.getAttribute("license"));
    ServletContext sc = this.getServletConfig().getServletContext();
    ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
    AdminMapper adminMapper = (AdminMapper) ac.getBean("adminMapper");
    Admin admin = adminMapper.selectAdminById(license);
%>

<div class="modal fade" id="update-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     style="display: none;">
    <div class="modal-dialog" style="width: 85%; max-width: 350px;">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
                <span class="acwing-brand">成绩预警系统</span>
            </div>
            <!-- Begin # DIV Form -->
            <div id>
                <!-- Begin # Login Form -->
                <form class="sign-form" role="form" modelAttribute="admin" action="/updateAdmin" method="post">
                    <input type='hidden' name='csrfmiddlewaretoken'
                           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
                    <div class="modal-body">
                        <div>
                            <div class="glyphicon glyphicon-chevron-right"></div>
                            <span>录入信息</span>
                        </div>

                        <input name="adminId" class="form-control" type="text" placeholder="密码" maxlength="30"
                               value="<%="证件号码："+admin.getAdminId()%>" disabled="disabled">

                        <input name="adminPassword" class="form-control" type="password" placeholder="密码"
                               maxlength="30" value="<%=admin.getAdminPassword()%>">
                        <input name="adminName" class="form-control" type="text" placeholder="姓名"
                               maxlength="30" value="<%=admin.getAdminName()%>">
                        <input name="adminTel" class="form-control" type="tex" placeholder="电话" maxlength="16"
                               value="<%=admin.getAdminTel()%>">
                        <input name="adminEmail" class="form-control" type="tex" placeholder="邮箱" maxlength="16"
                               value="<%=admin.getAdminEmail()%>">
                    </div>

                    <div class="modal-footer">
                        <div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
                        </div>
                    </div>
                </form>
                <!-- End # Login Form -->
            </div>
            <!-- End # DIV Form -->
        </div>
    </div>
</div>


<form action="/sendEmail" method="post">
    <table border="1" align="center" style="width: 95%">
        <%
            List list = (List) request.getAttribute("list");
            Iterator<Integer> iter = list.iterator();
            try {
                while (iter.hasNext()) {
                    Integer x = iter.next();
                    Student student = adminMapper.selectStudentById(x);
        %>
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-4">
                        学号: <b><%=student.getStudentId()%>
                    </b>
                    </div>
                    <div class="col-md-6">
                        姓名: <b><%=student.getStudentName()%>
                    </b>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        班级: <b><%=student.getStudentClassId()%>
                    </b>
                    </div>
                    <div class="col-md-4">
                        邮箱:<input name="email" maxlength="30" value="<%=student.getStudentEmail()%>" readonly="readonly">
                    </b>
                    </div>

                    <div class="col-md-4">
                        电话: <b><%=student.getStudentTel()%>
                    </b>
                    </div>
                </div>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    <div class="modal-footer">
        <div>
            <button type="submit" class="btn btn-primary btn-lg btn-block">发送邮件</button>
        </div>
    </div>
</form>


<div class="row center-banner">
    <div class="col-xs-12 center-banner-title">
    </div>
</div>
<script src="https://cdn.acwing.com/static/web/js/status/click.js"></script>
</body>
</html>

