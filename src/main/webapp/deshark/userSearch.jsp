<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/11/30
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查询页面</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#searchBtn").click(function () {
                var searchUsername = $("#searchUsername").val();

                $.ajax({
                    type: "POST",
                    url: "UserSearchServlet",
                    data: {"username": searchUsername},
                    success: function (data) {
                        // 填充用户信息到表单
                        fillForm(data);
                    }
                });
            });

            function fillForm(user) {
                // 填充学号
                $("#uid").val(user.uid);

                // 填充其余信息
                $("#email").val(user.email);
                $("#username").val(user.username);
                $("#password").val(user.password);
                $("#permission").val(user.permission);
                $("#sex").val(user.sex);

                // 显示用户头像
                if (user.avatar_url) {
                    $("#avatar_preview").attr("src", user.avatar_url);
                } else {
                    $("#avatar_preview").attr("src", ""); // 清空头像预览
                }
            }
        });

    </script>
</head>
<body>
    <h2>用户查询</h2>
    <label for="searchUsername">请输入用户名:</label>
    <input type="text" id="searchUsername" name="searchUsername">
    <button id="searchBtn">查询</button>

    <h2>用户信息</h2>
    <form name="updateUser" action="UpdateUserServlet" method="post" enctype="multipart/form-data">
        <label for="uid">学号:</label>
        <input type="number" id="uid" name="uid" required><br>
        <label for="email">邮箱:</label>
        <input type="text" id="email" name="email" required><br>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">密码:</label>
        <input type="text" id="password" name="password"><br>
        <label for="permission">权限:</label>
        <input type="text" id="permission" name="permission"><br>
        <label for="sex">性别:</label>
        <input type="text" id="sex" name="sex"><br>
        <label for="avatar_url">头像:</label>
<%--        <input type="text" id="avatar_url" name="avatar_url"><br>--%>
        <input type="file" id="avatar_url" name="avatar_url"><br>
        <img id="avatar_preview" src="" alt="Avatar Preview" style="max-width: 200px; max-height: 200px;"><br>

        <input type="submit" value="修改">
    </form>
</body>
</html>
