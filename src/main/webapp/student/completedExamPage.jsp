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
        <p>本次成绩：${requestScope.score}分</p>
        <div class="name-time">
            <p>姓名：${sessionScope.username}</p>
            <p>考试时间：${requestScope.examStartTime}&nbsp;至&nbsp; ${requestScope.examEndTime}</p>
        </div>
    </div>

</body>
</html>
