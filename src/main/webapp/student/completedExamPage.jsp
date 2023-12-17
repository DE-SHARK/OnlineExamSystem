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
</head>
<body>
    <div>
        <h1>考试完成</h1>
        <p>姓名：${sessionScope.username}</p>
        <p>成绩：${requestScope.score}</p>
        <p>考试时间：${requestScope.examStartTime}&nbsp;至&nbsp; ${requestScope.examEndTime}</p>
    </div>

</body>
</html>
