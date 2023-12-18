<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2023/12/17
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/Display.css">
</head>
<body>
    <div class="score-box">
        <c:if test="${requestScope.absent == 1}">
            <h1>缺考</h1>
        </c:if>
        <c:if test="${requestScope.absent == 0}">
            <h1>考试未开始</h1>
        </c:if>
        <div class="name-time">
            <p>姓名：${sessionScope.username}</p>
            <p>考试时间：${requestScope.examStartTime}&nbsp;至&nbsp;${requestScope.examEndTime}</p>
        </div>

    </div>


</body>
</html>
