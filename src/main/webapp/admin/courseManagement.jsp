<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: desha
  Date: 2023/12/18
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>课程管理页面</h2>

    <h2>课程列表</h2>

    <%--    EL 表达式--%>
    <%--    ${users}--%>

    <table>
        <thead>
        <tr>
            <th>课程号</th>
            <th>课程名</th>
            <th>是否为选修</th>
        </tr>
        </thead>
        <tbody>
        <%-- 遍历用户列表，显示用户信息 --%>
        <c:forEach var="item" items="${requestScope.itemList}">
            <tr>
                <td>${item.courseID}</td>
                <td>${item.courseName}</td>
                <td>${item.mandatory}</td>
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
                    <a href="course-management?page=${page}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</body>
</html>
