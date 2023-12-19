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
    <title>考试管理页面</title>
    <link href="../css/ExamManagement.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- 添加JavaScript代码 -->
    <script>
        function submitForm() {
            // 使用jQuery获取表单数据
            var formData = $("#examForm").serialize();

            // 发送AJAX请求
            $.ajax({
                type: "POST",
                url: "exam-add", // 替换为你的Servlet URL
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
    <h2>考试管理页面</h2>
    <h2>考试列表</h2>

    <table>
        <thead>
            <tr>
                <th>考试记录</th>
                <th>考试名</th>
                <th>考试科目</th>
                <th>是否为必修</th>
                <th>考试班级</th>
                <th>考试日期</th>
                <th>考试时长</th>
                <th>试题链接</th>
            </tr>
        </thead>
        <tbody>
        <%-- 遍历用户列表，显示用户信息 --%>
        <c:forEach var="item" items="${requestScope.itemList}">
            <tr>
                <td>${item.examId}</td>
                <td>${item.examName}</td>
                <td>${item.courseId}</td>
                <td>${item.mandatory}</td>
                <td>${item.trueClassId}</td>
                <td>${item.examDate}</td>
                <td>${item.timeLimits}</td>
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
                    <a href="exam-management?page=${page}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>

    <h2>添加考试</h2>
    <form id="examForm" action="" method="post" onsubmit="submitForm(); return false;">
        <label for="name">考试名：</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="courseId">考试科目：</label>
        <input type="text" id="courseId" name="courseId" required>
        <br>
        <label for="mandatory">是否为必修：</label>
        <select id="mandatory" name="mandatory">
            <option value="true" selected>是</option>
            <option value="false">否</option>
        </select>
        <br>
        <label for="trueClassId">考试班级：</label>
        <input type="text" id="trueClassId" name="trueClassId">
        <br>
        <label for="examDate">考试日期：</label>
        <input type="date" id="examDate" name="examDate">
        <br>
        <label for="examTime">考试时间：</label>
        <input type="time" id="examTime" name="examTime">
        <br>
        <label for="timeLimits">考试时长：</label>
        <input type="text" id="timeLimits" name="timeLimits">
        <br>

        <input type="submit" value="添加">
    </form>
    <!-- 添加一个用于显示成功消息的元素 -->
    <p id="successMessage"></p>
</body>
</html>
