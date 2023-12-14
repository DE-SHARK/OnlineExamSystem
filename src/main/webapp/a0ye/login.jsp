<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/11/27
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script>
        function validateForm() {
            let uid = escapeHtml(document.forms["loginForm"]["username"].value);
            let password = escapeHtml(document.forms["loginForm"]["password"].value);
            let captcha = escapeHtml(document.forms["loginForm"]["captcha"].value);

            function escapeHtml(unsafe) {
                return unsafe
                    .replace(/&/g, "&amp;")
                    .replace(/</g, "&lt;")
                    .replace(/>/g, "&gt;")
                    .replace(/"/g, "&quot;")
                    .replace(/'/g, "&#039;");
            }

            if (uid === "" || password === "" || captcha === "") {
                alert("请填写所有字段");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<h2>登录</h2>
<form name="loginForm" action="LoginServlet" method="post" onsubmit="return validateForm()">
    <label for="uid">学号:</label>
    <input type="text" id="uid" name="uid" required><br>

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="captcha">验证码:</label>
    <input type="text" id="captcha" name="captcha" required><br>
    <img src="CaptchaImageServlet" alt="Captcha Image">

    <!-- 此处可以添加验证码的展示逻辑，例如通过后台生成验证码图片 -->

    <br>

    <input type="submit" value="登录">
</form>
</body>
</html>
