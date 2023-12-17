<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>This is studentInformation</title>
    <link href="../css/ManagementMainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="title">在线考试系统
    <span class="userinfo">用户名:
        <a href="ModifyPassword.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../login.jsp">退出</a> </span>
</div>
<div class="centerContainer">
    <div class="leftBar">
        <ul>
            <li><a href="../ExamListServlet">我的考试</a></li>
            <li class="negative"><a style="background-color: #c8c8dc" href="GetStudentInformationServlet">我的信息</a></li>
        </ul>
    </div>
    <div class="main">
        <div style="text-align: center;">
            <h1>欢迎来到个人信息页面！</h1>

            <h1>头像</h1>
            <img src="${list[0].avatar_url}" width="150" height="autp">

            <p>Uid:${list[0].uid}</p>
            <p>Username:${list[0].username}</p>
            <p>Email:${list[0].email}</p>
            <p>Sex:${list[0].sex}</p>

        </div>
    </div>
</div>
<div class="footer">Copyright&nbsp;&copy;&nbsp;602</div>
</body>
</html>
