<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/11/29
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#username").blur(function () {
                let username = $("#username").val();

                $.ajax({
                    type: "POST",
                    url: "CheckUsernameServlet",
                    data: {"username": username},
                    success: function (data) {
                        if (data === "true") {
                            $("#usernameAvailability").text("用户名可用");
                        } else {
                            $("#usernameAvailability").text("用户名已被使用，请选择其他用户名");
                        }
                    }
                });
            });
        });
    </script>

</head>
<body>
    <h2>用户注册</h2>
    <form name="registerForm" action="RegisterServlet" method="post" onsubmit="return validateForm()">
        <label for="uid">学号:</label>
        <input type="number" id="uid" name="uid" required><br>
        <label for="email">邮箱:</label>
        <input type="text" id="email" name="email" required><br>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
        <span id="usernameAvailability"></span><br>

        <!-- 其他注册信息的输入框 -->

        <br>

        <input type="submit" value="注册">
    </form>
</body>
</html>
