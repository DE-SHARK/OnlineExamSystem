<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.8.0.min.js"></script>
    <script>
        $(function() {
            $(document).ready(function () {
                var url = "${sessionScope.testpaper_url}";
                $.post("/student/GetExamnationServlet", {"exam_url": url}, function (rs) {
                    var questions = rs.questions;
                    $("#questionsLength").val(questions.length);

                    for (var i = 0; i < questions.length; i++) {
                        var topicValue = questions[i].topic;
                        var chooseOptions = questions[i].choose;

                        var questionDiv = $("<div>");

                        questionDiv.append("<p>" + (i + 1) + ":   " + topicValue + "</p>");

                        var optionsArray = chooseOptions.split(' ');

                        for (var j = 0; j < optionsArray.length; j++) {
                            var optionParts = optionsArray[j].split('.');
                            questionDiv.append('<label><input type="radio" name="answer_' + i + '" value="' + optionParts[0] + '"> ' + optionsArray[j] +'</label>');
                        }

                        $("#examForm").append(questionDiv).append("<br><br>");
                    }
                    $("#examForm").append('<input type="submit" value="Submit">');
                });
            });
        });
    </script>
</head>
<body>
<form id="examForm" action="<c:url value="/student/SendStudentAnswerServlet"/>" method="post">
    <input type="hidden" id="questionsLength" name="questionsLength">
</form>
</body>
</html>

