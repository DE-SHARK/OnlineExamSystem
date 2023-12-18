<%--
  Created by IntelliJ IDEA.
  User: 17691
  Date: 6/3/2019
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is AdministratorIndex</title>
    <link href="../css/ManagementMainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="title">在线考试系统
    <span class="userinfo">用户名:<a href="/ModifyPassword.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../login.jsp">退出</a> </span>
</div>
<div class="centerContainer">
    <div class="leftBar">
        <ul>
            <li><a style="background-color: #c8c8dc" href="teacherPage.jsp">首页导航</a></li>
            <li class="negative"><a href="ChooseExam.jsp">教师改卷</a></li>
            <li class="negative"><a href="QuestionsManagement.jsp">试题管理</a></li>
            <li class="negative"><a href="/teacher/GetTeacherInformationServlet">教师信息</a></li>
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
