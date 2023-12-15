<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/12/15
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>学生管理页面</title>
</head>
<body>
    <h2>学生管理页面</h2>

    <p>随机生成一些学生数据</p>

    <form action="generate-students" method="post">
        <label for="uidStart">请输入起始学号：</label>
        <input type="text" id="uidStart" name="uidStart" required>
        <br>

        <label for="numberOfStudents">请输入学生数：</label>
        <input type="number" id="numberOfStudents" name="numberOfStudents" required>
        <br>

        <input type="submit" value="生成学生数据">
    </form>
    <p>${requestScope.successMessage}</p>
</body>
</html>
