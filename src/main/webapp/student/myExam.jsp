<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2023/12/16
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/MyExamStyle.css">
</head>

<body>
    <div class="head">
        <p>欢迎你，${username}</p>
    </div>
    <div class="head_tips">
        <p>退出或离开答题页面，答题计时不暂停，进入考试后请不要中途离开，以防超时系统自动收卷。</p>
    </div>
    <div class="body_list">
        <h4 style="text-align: left">考试列表</h4>
        <table >
            <tr>
                <th>编号</th>
                <th>考试名称</th>
                <th>考试时间</th>
                <th>考试时长</th>
                <th>状态</th>
                <th>成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach var="exam" items="${examList}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${exam.exam_name}</td>
                    <td>${exam.exam_date}</td>
                    <td>${exam.time_limits}</td>
                    <c:if test="${exam.status == 0}">
                        <td>未完成</td>
                    </c:if>
                    <c:if test="${exam.status == 1}">
                        <td>已完成</td>
                    </c:if>
                    <c:if test="${exam.status == 0}">
                        <td>---</td>
                    </c:if>
                    <c:if test="${exam.status == 1}">
                        <td>${exam.score}</td>
                    </c:if>
                    <td>
                        <a>查看</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分页控件 -->
        <div class="pagination-container">
            <c:if test="${not empty noOfPages and not empty currentPage}">
                <a href="?page=1&stu_id=${param.stu_id}&username=${param.username}">首页</a>
                <c:if test="${currentPage > 1}">
                    <a href="?page=${currentPage-1}&stu_id=${param.stu_id}&username=${param.username}">上一页</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${noOfPages}">
                    <c:choose>
                        <c:when test="${i eq currentPage}">
                            <b>${i}</b>
                        </c:when>
                        <c:otherwise>
                            <a href="?page=${i}&stu_id=${param.stu_id}&username=${param.username}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage < noOfPages}">
                    <a href="?page=${currentPage + 1}&stu_id=${param.stu_id}&username=${param.username}">下一页</a>
                </c:if>
                <a href="?page=${noOfPages}&stu_id=${param.stu_id}&username=${param.username}">末页</a>
            </c:if>
        </div>

    </div>


</body>
</html>
