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
    <link rel="stylesheet" type="text/css" href="../css/MyExamStyle.css">
</head>

<body>
    <div class="head">
        <p>欢迎你，${sessionScope.username}</p>
    </div>
    <div class="head_tips">
        <p>退出或离开答题页面，答题计时不暂停，进入考试后请不要中途离开，以防超时系统自动收卷。</p>
    </div>
    <div class="body_list">
        <h1 style="text-align: left">考试列表</h1>
        <table class="exam-list">
            <tr>
                <th>编号</th>
                <th>考试名称</th>
                <th>考试时间</th>
                <th>考试时长</th>
                <th>状态</th>
                <th>成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach var="exam" items="${requestScope.examList}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${exam.examName}</td>
                    <td>${exam.examDate}&nbsp;至&nbsp;${exam.examEnd}</td>
                    <td>${exam.timeLimits}</td>
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
                        <form action="<c:url value="/student/exam-page-servlet"/>" method="post">
                            <input type="hidden" name="exam_date" value="${exam.examDate}">
                            <input type="hidden" name="exam_end" value="${exam.examEnd}">
                            <input type="hidden" name="exam_id" value="${exam.examId}">
                            <input type="hidden" name="status" value="${exam.status}">
                            <input type="hidden" name="score" value="${exam.score}">
                            <input type="hidden" name="testpaper_url" value="${exam.testPaperUrl}">
                            <input type="hidden" name="course_id" value="${exam.courseId}">
                            <input type="submit" value="查看">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分页控件 -->
        <div class="pagination-container">
            <c:if test="${not empty requestScope.noOfPages and not empty requestScope.currentPage}">
                <a href="?page=1">首页</a>
                <c:if test="${requestScope.currentPage > 1}">
                    <a href="?page=${requestScope.currentPage-1}">上一页</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${requestScope.noOfPages}">
                    <c:choose>
                        <c:when test="${i eq requestScope.currentPage}">
                            <b>${i}</b>
                        </c:when>
                        <c:otherwise>
                            <a href="?page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${requestScope.currentPage < requestScope.noOfPages}">
                    <a href="?page=${requestScope.currentPage + 1}">下一页</a>
                </c:if>
                <a href="?page=${requestScope.noOfPages}">末页</a>
            </c:if>
        </div>
    </div>
</body>
</html>
