<%--
  Created by IntelliJ IDEA.
  User: 13159
  Date: 2023/12/15
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>密码修改</title>
    <link rel="stylesheet" href="/css/ModifyPasswordStyle.css">
    <script>
        <%-- 获取错误消息 --%>
        var errorMessage = "${errorMessage}";
        <%-- 检查是否存在错误消息 --%>
        if (errorMessage) {
            <%-- 弹出提示框 --%>
            window.alert(errorMessage);
        }

    </script>
</head>
<body>
<form method="post" action="../ModifyPasswordServlet">
    <label for="currentPassword">当前密码:</label>
    <input type="password" id="currentPassword" name="currentPassword" required><br><br>

    <label for="newPassword">新密码:</label>
    <input type="password" id="newPassword" name="newPassword" required><br><br>

    <input type="submit" value="修改密码">
</form>

</body>
</html>
