<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: c~java--%>
<%--  Date: 2023/12/15--%>
<%--  Time: 10:02--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <script src="./js/jquery-1.8.0.min.js"></script>--%>
<%--    <script>--%>
<%--        $(function() {--%>
<%--            $(document).ready(function () {--%>
<%--                &lt;%&ndash;$.post("/GetExamnation","examurl=${examurl}",function(rs){&ndash;%&gt;--%>
<%--                $.post("/GetExamnationServlet", {"examurl": "C:/Study_Information/git本地仓库/OnlineExamSystem/math_exam.json"}, function (rs) {--%>
<%--                    var questions = rs.questions;--%>

<%--                    for (var i = 0; i < questions.length; i++) {--%>
<%--                        var topicValue = questions[i].topic;--%>
<%--                        var chooseOptions = questions[i].choose;--%>

<%--                        var questionDiv = $("<div>");--%>

<%--                        questionDiv.append("<p>" +(i+1)+ ":   "+topicValue+ "</p>");--%>

<%--                        var optionsArray = chooseOptions.split(' ');--%>

<%--                        for (var j = 0; j < optionsArray.length; j++) {--%>
<%--                            var optionParts = optionsArray[j].split('.');--%>
<%--                            questionDiv.append('<label><input type="radio" name="answer_' + i + '" value="' + optionParts[0] + '"> ' + optionsArray[j] + '</label>');--%>
<%--                        }--%>

<%--                        $("#examForm").append(questionDiv).append("<br><br>");--%>
<%--                    }--%>
<%--                    $("#examForm").append('<input type="submit" value="Submit">');--%>
<%--                });--%>
<%--            })--%>
<%--        })--%>

<%--        $("#examForm").submit(function (event) {--%>
<%--            event.preventDefault();--%>
<%--            for (var i = 0; i < questions.length; i++) {--%>
<%--                var selectedValue = $("input[name='answer_" + i + "']").val();--%>
<%--            }--%>

<%--        });--%>


<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <form id="examForm">--%>
<%--        <input type="text">--%>

<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-1.8.0.min.js"></script>
    <script>
        $(function() {
            $(document).ready(function () {
                $.post("/GetExamnationServlet", {"examurl": "C:/Study_Information/git本地仓库/OnlineExamSystem/math_exam.json"}, function (rs) {
                    var questions = rs.questions;

                    // Set the length of questions array in a hidden field
                    $("#questionsLength").val(questions.length);

                    for (var i = 0; i < questions.length; i++) {
                        var topicValue = questions[i].topic;
                        var chooseOptions = questions[i].choose;

                        var questionDiv = $("<div>");

                        questionDiv.append("<p>" + (i + 1) + ":   " + topicValue + "</p>");

                        var optionsArray = chooseOptions.split(' ');

                        for (var j = 0; j < optionsArray.length; j++) {
                            var optionParts = optionsArray[j].split('.');
                            questionDiv.append('<label><input type="radio" name="answer_' + i + '" value="' + optionParts[0] + '"> ' + optionsArray[j] + '</label>');
                        }

                        $("#examForm").append(questionDiv).append("<br><br>");
                    }
                    $("#examForm").append('<input type="submit" value="Submit">');
                });

                $("#examForm").submit(function (event) {
                });
            });
        });
    </script>
</head>
<body>
<form id="examForm" action="/SendStudentAnswerServlet" method="post">
    <input type="hidden" id="questionsLength" name="questionsLength">
</form>
</body>
</html>

