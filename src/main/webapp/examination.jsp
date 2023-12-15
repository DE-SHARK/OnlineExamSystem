<%--
  Created by IntelliJ IDEA.
  User: c~java
  Date: 2023/12/15
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-1.8.0.min.js"></script>
    <script>
        $(function(){
            $(document).ready(function(){
                <%--$.post("/GetExamnation","examurl=${examurl}",function(rs){--%>
                $.post("/GetExamnationServlet",{"examurl": "C:/Study_Information/git本地仓库/OnlineExamSystem/math_exam.json"},function(rs){
                    console.log(rs); // 打印返回的数据到控制台
                    var jsonData = JSON.parse(rs);
                    document.body.innerHTML = '<pre>' + JSON.stringify(jsonData, null, 2) + '</pre>';
                    // document.body.innerHTML = '<pre>' + rs + '</pre>';
                });
            });
        })
    </script>
</head>
<body>

</body>
</html>
