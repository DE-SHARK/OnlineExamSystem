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
            padding: 8px;
            text-align: left;
        }

        table.exam-list th {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>

    <table class="exam-list">
        <tr>
            <th>课程名称</th>
            <th>成绩</th>
        </tr>
        <c:forEach var="studentgrade" items="${sessionScope.StudentGrade}">
            <tr>
                <td>${studentgrade.course_name}</td>
                <td>${studentgrade.grade}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
