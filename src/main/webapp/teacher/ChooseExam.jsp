<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2023/12/16
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <%=request.getParameter("message")%>
    <form action="ChooseExamServlet" method="post">
        要查询的课程名称<input type="text" name="course_name">
        <input type="submit" value="查询" >
    </form>
    <table class="exam-list">
        <tr>
            <th>学号</th>
            <th>学生姓名</th>
            <th>考试名称</th>
            <th>查看</th>
        </tr>
        <c:forEach var="studentexam" items="${sessionScope.examlist}">
            <tr>
                <td>${studentexam.stu_id}</td>
                <td>${student.stu_name}</td>
                <td>${student.course_name}</td>
                <td id="exam_url" onclick="viewExam('${studentexam.stu_id}', '${studentexam.testpaper_url}')">查看试卷</td>

            </tr>
        </c:forEach>
    </table>
    <script>
        function viewExam(studentId, examUrl) {
            const encodedStuId = encodeURIComponent(studentId);
            const encodedExamUrl = encodeURIComponent(examUrl);
            window.location.href = `GetPaperContentServlet?stu_id=${encodedStuId}&exam_url=${encodedExamUrl}`;
        }
    </script>

</body>
</html>
