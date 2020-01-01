<%@ page import="com.group.javaee.Pojo.StudentAndGrade" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.group.javaee.Pojo.StudentAndGradeAndCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
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


<body>
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
                <li class=""><a href="adminSelect">管理员查询</a></li>
                <li><a href="/studentGradeManage">学生成绩管理</a></li>
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

<form action="saveStudentGrade" method="post" name="a">
    <table border="1" align="center" style="width: 95%">
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-3">
                        学号
                    </div>
                    <div class="col-md-3">
                        姓名
                    </div>
                    <div class="col-md-3">
                        课程
                    </div>

                    <div class="col-md-3">
                        成绩
                    </div>

                </div>
            </td>
        </tr>


        <%
            List<StudentAndGradeAndCourse> list = (List<StudentAndGradeAndCourse>) request.getAttribute("StudentAndGradeAndCourseList");
            Iterator<StudentAndGradeAndCourse> it = list.iterator();

            while (it.hasNext()) {
                StudentAndGradeAndCourse SAGAC = it.next();
        %>
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-3">
                        <b><%=SAGAC.getStudentId() %>
                        </b>
                    </div>
                    <div class="col-md-3">
                        <b><%=SAGAC.getStudentName()%>
                        </b>
                    </div>

                    <div class="col-md-3">
                        <b><%=SAGAC.getCourseName()%>
                        </b>
                    </div>

                    <div class="col-md-3">
                        <input name="password" class="form-control" type="text" placeholder="成绩" maxlength="5" value="<%=SAGAC.getGrade()%>">
                    </div>

                </div>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div class="modal-footer">
        <div>
            <button type="submit" class="btn btn-primary btn-lg btn-block">保存</button>
        </div>
    </div>
</form>

</body>
</html>
