<%--
  Created by IntelliJ IDEA.
  User: 13159
  Date: 2023/12/18
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is AdministratorIndex</title>
    <link href="../css/ManagementMainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="title">在线考试系统
    <span class="userinfo">用户名:<a href="/student/ModifyPassword.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../login.jsp">退出</a> </span>
</div>
<div class="centerContainer">
    <div class="leftBar">
        <ul>
            <li><a style="background-color: #c8c8dc" href="teacherPage.jsp">首页导航</a></li>
            <li class="negative"><a href="teacherGrading.jsp">教师改卷</a></li>
            <li class="negative"><a href="QuestionsManagement.jsp">试题管理</a></li>
            <li class="negative"><a href="../GetTeacherInformationServlet">教师信息</a></li>
        </ul>
    </div>

    <div class="main">
        <div style="text-align: center;">
            <h1>欢迎来到个人信息页面！</h1>
            <h2>以下是个人信息展示</h2>
            <%--            图像路径保存正确，但上传到数据库失败，且若存在已保存的图片则写入冲突报错--%>
            <%--            <form action="../ImageUploadServlet" method="post" enctype="multipart/form-data">--%>
            <%--                <input type="file" name="image">--%>
            <%--                <input type="submit" value="上传图片">--%>
            <%--            </form>--%>

            <img src="${list[0].avatar_url}" width="150" height="auto">
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
