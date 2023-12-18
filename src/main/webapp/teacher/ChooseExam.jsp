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
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f2f2f2;
        }

        form {
            margin-bottom: 20px;
        }

        table.exam-list {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table.exam-list th, table.exam-list td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        table.exam-list th {
            background-color: #4CAF50;
            color: white;
        }

        table.exam-list tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        table.exam-list tr:hover {
            background-color: #f1f1f1;
        }

        td#exam_url {
            cursor: pointer;
            color: #0066cc;
            text-decoration: underline;
        }
    </style>
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
                <td>${studentexam.stu_name}</td>
                <td>${studentexam.course_name}</td>
                <td id="exam_url" onclick="viewExam('${studentexam.stu_id}', '${studentexam.testpaper_url}', '${studentexam.course_id}', '${studentexam.exam_id}')">查看试卷</td>

            </tr>
        </c:forEach>
    </table>
    <script>
        function viewExam(studentId, examUrl, course_id, exam_id) {
            const encodedStuId = studentId;
            const encodedExamUrl = examUrl;
            const encodedCourseId = course_id;
            const encodedExamId = exam_id;
            window.location.href = "GetPaperContentServlet?stu_id=" + encodedStuId + "&exam_url="+encodedExamUrl + "&course_id=" + encodedCourseId + "&exam_id=" + encodedExamId;
        }
    </script>

</body>
</html>
