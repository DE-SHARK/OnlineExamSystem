<%@ page import="java.util.List" %>
<%@ page import="me.xizhehong.Bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        #tl{
            align-content: center;
        }
    </style>
</head>

<body>
${Student[0].username}
<table id = "tl">
    <tbody>
    <tr align="center">
        <th>用户名</th>
        <th>真实姓名</th>
        <th>学号</th>
        <th>性别</th>
        <th>专业</th>
    </tr>

    <c:forEach items="${Student}" var="stu">
        <tr>
            <td>${stu.username}</td>
            <td>${stu.realname}</td>
            <td>${stu.usernumber}</td>
            <td>${stu.sex}</td>
            <td>${stu.profession}</td>
        </tr>

    </c:forEach>
        </tbody>
</table>
</body>
</html>
