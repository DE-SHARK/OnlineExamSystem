<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/12/18
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理页面</title>
</head>
<body>
    <h2>学生列表</h2>

    <%--    EL 表达式--%>
    <%--    ${users}--%>

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
        <c:forEach var="user" items="${requestScope.userList}">
            <tr>
                <td>${user.uid}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.sex}</td>
                <td>${user.register_at}</td>
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
                    <a href="teacher-management?page=${page}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
    <p>${requestScope.successMessage}</p>

    <h2>添加教师</h2>

    <form action="teacher-add" method="post">
        <label for="uid">教师号：</label>
        <input type="text" id="uid" name="uid" required>
        <br>

        <label for="name">姓名：</label>
        <input type="text" id="name" name="name">
        <br>

        <label for="sex">性别：</label>
        <input type="text" id="sex" name="sex">
        <br>

        <input type="submit" value="添加">
    </form><br>

    <p>随机生成一些学生数据</p>

    <form action="generate-teachers" method="post">
        <label for="uidStart">请输入起始教师号：</label>
        <input type="text" id="uidStart" name="uidStart" required>
        <br>

        <label for="numberOfTeachers">请输入教师数：</label>
        <input type="number" id="numberOfTeachers" name="numberOfTeachers" required>
        <br>

        <input type="submit" value="生成教师数据">
    </form>
    <p>${requestScope.successMessage}</p>
</body>
</html>
