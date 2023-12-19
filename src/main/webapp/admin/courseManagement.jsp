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
    <title>课程管理页面</title>
    <link href="../css/CourseManagement.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- 添加JavaScript代码 -->
    <script>
        function submitForm() {
            // 使用jQuery获取表单数据
            var formData = $("#courseForm").serialize();

            // 发送AJAX请求
            $.ajax({
                type: "POST",
                url: "course-add",
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
    <h2>课程管理页面</h2>
    <h2>课程列表</h2>

    <table>
        <thead>
            <tr>
                <th>课程号</th>
                <th>课程名</th>
                <th>是否为必修</th>
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

    <h2>添加课程</h2>

    <form id="courseForm" action="" method="post" onsubmit="submitForm(); return false;">
        <label for="name">课程名字：</label>
        <input type="text" id="name" name="name" required>
        <br>

        <label for="mandatory">是否为必修：</label>
        <select id="mandatory" name="mandatory">
            <option value="true" selected>是</option>
            <option value="false">否</option>
        </select>
        <br>

        <input type="submit" value="添加">
    </form>
    <!-- 添加一个用于显示成功消息的元素 -->
    <p id="successMessage"></p>
</body>
</html>
