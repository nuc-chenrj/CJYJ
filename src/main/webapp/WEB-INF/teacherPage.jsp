<%--
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
                <li class=""><a href="">公示</a></li>
                <li class=""><a href="">实施办法</a></li>
                <li class=""><a href="">管理员/老师查询</a></li>
                <li class=""><a href="">建议</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" data-toggle="modal" data-target="#login-modal">登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
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
                <form class="sign-form" id="login-form" role="form" action="PageJumpServlet" method="post">
                    <input type='hidden' name='csrfmiddlewaretoken'
                           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
                    <div class="modal-body">
                        <div id="div-login-msg">
                            <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                            <span id="text-login-msg">请输入登录信息</span>
                        </div>
                        <input name="license" class="form-control" type="text" placeholder="证件号" maxlength="30">
                        <input name="password" class="form-control" type="password" placeholder="密码" maxlength="16">
                    </div>
                    <div class="modal-footer">
                        <div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                        </div>
                    </div>

                </form>
                <!-- End # Login Form -->
            </div>
            <!-- End # DIV Form -->
        </div>
    </div>
</div>


<div class="row center-banner">
    <div class="col-xs-12 center-banner-title">
    </div>
</div>
<script src="https://cdn.acwing.com/static/web/js/status/click.js"></script>
</body>
</html>

