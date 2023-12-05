<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="users" type="me.deshark.controller.UserListServlet"--%>
<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/12/1
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户列表</title>
    <script>
        // JavaScript函数，用于触发导出操作
        function exportExcel() {
            // 使用Ajax请求后端Servlet进行导出
            let xhr = new XMLHttpRequest();
            xhr.open("GET", "ExportExcelServlet", true);
            xhr.send();
        }
    </script>
</head>
<body>
    <h2>用户列表</h2>

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
                        <td><c:out value="${user.uid}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.username}" /></td>
                        <td><c:out value="${user.sex}" /></td>
                        <td><c:out value="${user.register_at}" /></td>
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
                        <a href="UserListServlet?page=${page}">${page}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
    </div>

    <!-- 添加导出按钮 -->
    <button onclick="exportExcel()">导出学生信息</button>
</body>
</html>
