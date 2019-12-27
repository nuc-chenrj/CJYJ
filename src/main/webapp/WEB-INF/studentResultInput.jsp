<%@ page import="java.util.List" %>
<%@ page import="javax.validation.constraints.AssertFalse" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.group.javaee.Mapper.AdminMapper" %>
<%@ page import="com.group.javaee.Mapper.TeacherMapper" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %><%--
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
                <li class=""><a href="">管理员查询</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        学生成绩管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#add-modal">成绩录入</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#borrow-modal">成绩查询</a></li>
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
            <div id="">
                <!-- Begin # Login Form -->
                <form class="sign-form" role="form" modelAttribute="teacher" action="/updateTeacher" method="post">
                    <input type='hidden' name='csrfmiddlewaretoken'
                           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
                    <div class="modal-body">
                        <div>
                            <div class="glyphicon glyphicon-chevron-right"></div>
                            <span>录入信息</span>
                        </div>
                        <input name="teacherPassword" class="form-control" type="password" placeholder="密码"
                               maxlength="30">
                        <input name="teacherName" class="form-control" type="" placeholder="姓名" maxlength="30">
                        <input name="teacherEmail" class="form-control" type="email" placeholder="邮箱" maxlength="30">
                        <input name="teacherTel" class="form-control" type="text" placeholder="电话" maxlength="30">
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
    TeacherMapper teacherMapper = (TeacherMapper) ac.getBean("teacherMapper");
    System.out.println(teacherMapper.selectClassId(license));
    Set<Integer> classlist = teacherMapper.selectClassId(license);
    Iterator<Integer> iter = classlist.iterator();
%>


<form action="SearchBookServlet" method="post">
    <input type='hidden' name='csrfmiddlewaretoken'
           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
    <div>
        <div>
            <div class="glyphicon glyphicon-chevron-right"></div>
            <span>成绩录入</span>
        </div>
        <div style="display: inline">
            <label style="vertical-align: top">班级：</label>

            <select id="classID" onchange="goChange()" style="width: 130px;height: 20px; vertical-align: top">
                <%
                    try {
                        while (iter.hasNext()) {
                            Integer x = iter.next();
                %>
                <option value="ISBN"><%=x %></option>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </select>

        </div>
        <div style="display: inline; vertical-align: bottom">
            <label>检索词：</label>
            <input name="searchname" style="width: 130px;height: 20px; vertical-align: top" type="tex" size="30">
            <input type="submit" style="width:50px;height: 20px; line-height: 20px;padding: 0;margin: 0" value="检索"/>
        </div>
    </div>
</form>


<div class="row center-banner">
    <div class="col-xs-12 center-banner-title">
    </div>
</div>

<script>
    function goChange(){
        window.location.href="test?value="+document.getElementById("classID").value;
    }
</script>
<script src="https://cdn.acwing.com/static/web/js/status/click.js"></script>
</body>
</html>

