<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2023/12/18
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>进入考试</title>
    <link rel="stylesheet" href="../css/Display.css">
</head>
<body>
<div class="score-box">
    <h1>考试进行中</h1>
    <div class="name-time">
        <p>姓名：${sessionScope.username}</p>
        <p>考试时间：${sessionScope.exam_date}&nbsp;至&nbsp; ${sessionScope.exam_end}</p>
    </div>
    <div >
        <form action="<c:url value="/student/exam-page-servlet"/>" method="post">
            <input type="hidden" name="exam_date" value="${sessionScope.exam_date}">
            <input type="hidden" name="exam_end" value="${sessionScope.exam_end}">
            <input type="hidden" name="exam_id" value="${sessionScope.exam_id}">
            <input type="hidden" name="status" value="${sessionScope.status}">
            <input type="hidden" name="score" value="${sessionScope.score}">
            <input type="hidden" name="testpaper_url" value="${sessionScope.testpaper_url}">
            <input type="hidden" name="course_id" value="${sessionScope.course_id}">
            <input type="hidden" name="confirm" value="ture">
            <input id="confirm-button" type="submit" value="进入考试">
        </form>
    </div>
</div>
</body>
</html>
