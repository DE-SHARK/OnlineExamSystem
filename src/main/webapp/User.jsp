<%--
  Created by IntelliJ IDEA.
  User: c~java
  Date: 2023/12/4
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-1.8.0.min.js"></script>

</head>
<body>
    <h5>目前登录用户为：${testCount.username}</h5>
    <a href="${pageContext.request.contextPath}/UserMangeServlet">学生用户管理</a>
    <form action="DownloadServlet" method="get">
        <input type="submit" value="下载学生表">
    </form>
</body>
</html>
