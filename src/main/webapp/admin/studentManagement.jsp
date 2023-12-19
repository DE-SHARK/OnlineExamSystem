<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="../css/StudentManagementStyle.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- 添加JavaScript代码 -->
    <script>
        function submitForm() {
            // 使用jQuery获取表单数据
            var formData = $("#studentForm").serialize();

            // 发送AJAX请求
            $.ajax({
                type: "POST",
                url: "student-add",
                data: formData,
                success: function(response) {
                    // 返回添加结果
                    $("#successMessage").text(response);
                }
            });
        }
    </script>
</head>
<body>
    <h2>学生管理页面</h2>
    <h2>学生列表</h2>

    <table>
        <thead>
        <tr>
            <th>学号</th>
            <th>邮箱</th>
            <th>姓名</th>
            <th>性别</th>
            <th>注册时间</th>
        </tr>
        </thead>
        <tbody>
        <%-- 遍历用户列表，显示用户信息 --%>
        <c:forEach var="item" items="${requestScope.itemList}">
            <tr>
                <td>${item.uid}</td>
                <td>${item.email}</td>
                <td>${item.username}</td>
                <td>${item.sex}</td>
                <td>${item.register_at}</td>
                <!-- 其他列 -->
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="pagination">
        <%-- 分页链接将在此处动态生成 --%>
        <span>第${requestScope.currentPage}页</span>
        <c:forEach begin="1" end="${requestScope.totalPages}" var="page">
            <c:choose>
                <c:when test="${page == requestScope.currentPage}">
                    <span>${page}</span>
                </c:when>
                <c:otherwise>
                    <a href="student-management?page=${page}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>

    <h2>添加学生</h2>

    <form id="studentForm" action="" method="post" onsubmit="submitForm(); return false;">
        <label for="uid">学号：</label>
        <input type="text" id="uid" name="uid" required>
        <br>

        <label for="name">姓名：</label>
        <input type="text" id="name" name="name">
        <br>

        <label for="sex">性别：</label>
        <input type="text" id="sex" name="sex">
        <br>

        <input type="submit" value="添加">
    </form>
    <!-- 添加一个用于显示成功消息的元素 -->
    <p id="successMessage"></p><br>

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
