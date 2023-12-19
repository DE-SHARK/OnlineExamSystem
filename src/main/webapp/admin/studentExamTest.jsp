<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/12/19
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>考试列表</h2>

    <table>
        <thead>
        <tr>
            <th>考试名字</th>
            <th>考试时间</th>
            <th>考试时长</th>
        </tr>
        </thead>
        <tbody>
        <%-- 遍历用户列表，显示用户信息 --%>
        <c:forEach var="item" items="${requestScope.itemList}">
            <tr>
                <td>${item.examName}</td>
                <td>${item.examDate}</td>
                <td>${item.timeLimits}</td>
                <!-- 其他列 -->
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
