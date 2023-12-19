<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2023/12/17
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/Display.css">
</head>
<body>
    <div class="score-box">
        <h1>考试完成</h1>
        <c:if test="${requestScope.score != -1}">
            <span>本次成绩：</span><span id="score">${requestScope.score}</span> <span>分</span>
        </c:if>
        <c:if test="${requestScope.score == -1}">
            <span>老师还未批阅</span>
        </c:if>

        <div class="name-time">
            <table>
                <tr>
                    <td>姓名：${sessionScope.username}</td><td></td>
                </tr>
                <tr>
                    <td>考试时间：</td><td>${requestScope.examStartTime}</td>
                </tr>
                <tr>
                    <td></td><td style="text-align: center">至</td>
                </tr>
                <tr>
                    <td></td><td>${requestScope.examEndTime}</td>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>
