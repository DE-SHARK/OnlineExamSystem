<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
<%--    <link rel="shortcut icon"  href="../image/ExamTitleIcon.ico">--%>
    <title>This is StudentPage</title>
    <link href="../css/ManagementMainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="title">在线考试系统
    <span class="userinfo">用户名:<a href="ModifyPassword.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../login.jsp">退出</a> </span>
</div>
<div class="centerContainer">
    <div class="leftBar">
        <ul>
            <li><a style="background-color: #c8c8dc" href="StudentIndex.jsp">首页导航</a></li>
            <li class="negative"><a href="MyExam.jsp">我的考试</a></li>
            <li class="negative"><a href="MyInformation.jsp">我的信息</a></li>
        </ul>
    </div>
    <div class="main">
        <div style="text-align: center;">
            <h1>欢迎来到在线考试系统！</h1>
        </div>
    </div>
</div>
<div class="footer">Copyright&nbsp;&copy;&nbsp;602</div>
</body>
</html>
