<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: c~java
  Date: 2023/12/17
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>改卷</title>
    <script src="../js/jquery-1.8.0.min.js"></script>
    <script>
        $(function (){
            // var exam_url = "C:/Study_Information/git本地仓库/OnlineExamSystem/math_exam.json";
            $(document).ready(function (){
                var url = "${sessionScope.testpaper_url}";
                $.post("/teacher/StudentExamServlet", {"exam_url": url}, function (rs) {
                    var questions = rs.questions;
                    <%--var answers =rs["${sessionScope.stu_id}"];--%>
                    var answers = rs["2100502101"];

                    for (var i = 0; i < questions.length; i++) {
                        var topicValue = questions[i].topic;
                        var chooseOptions = questions[i].choose;
                        var answer = answers["answer" + i];
                        var questionDiv = $("<div>");

                        questionDiv.append("<p>" +"Student Answer:" + answer+"</p>");
                        questionDiv.append("<p>" + (i + 1) + ":   " + topicValue + "</p>");

                        var optionsArray = chooseOptions.split(' ');

                        for (var j = 0; j < optionsArray.length; j++) {
                            var optionParts = optionsArray[j].split('.');
                            questionDiv.append('<label><input type="radio" name="answer_' + i + '" value="' + optionParts[0] + '"> ' + optionsArray[j] +'</label>');
                        }

                        $("#studentExamForm").append(questionDiv).append("<br><br>");
                    }
                    // $("#studentExamForm").append("学生的分数为:"+'<input type="text" id="grade" name="garde">'+"<br>");
                    $("#studentExamForm").append('<input type="submit" value="Submit">');
                })
            })
        })
    </script>
</head>
<body>
    <form id="studentExamForm" action="<c:url value="/teacher/GiveGradeServlet"/>" method="post">
        <div>

        </div>
        <input type="text" name="grade">
    </form>
</body>
</html>
