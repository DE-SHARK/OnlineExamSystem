<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>This is studentInformation</title>
    <link href="../css/ManagementMainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="title">在线考试系统
    <span class="userinfo">用户名:
        <a href="ModifyPassword.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../login.jsp">退出</a> </span>
</div>
<div class="centerContainer">
    <div class="leftBar">
        <ul>
            <li><a href="../ExamListServlet">我的考试</a></li>
            <li class="negative"><a style="background-color: #c8c8dc" href="GetStudentInformationServlet">我的信息</a></li>
        </ul>
    </div>

    <div class="main">
        <div style="text-align: center;">
            <h1>欢迎来到学生个人信息页面！</h1>
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="imageFile" />
                <input type="submit" value="Upload" />
            </form>

            <h1>头像</h1>
            <%--            <img src="${avatarPath}" alt="Avatar">--%>
            <%--            <img src="/image/v2.jpg" alt="Image" width="150" height="auto">--%>
            <%--            <img src="${filePath}" alt="Image" width="150" height="auto">--%>

            <%--            <a href="DownloadServlet?fileName=image.jpg">Download Image</a>--%>

            <img src="${studentInformationList[0].avatar_url}" width="150" height="auto">
            <%--            <img src="/image/v2.jpg" width="150" height="auto">--%>
            <p>Uid: ${studentInformationList[0].uid}</p>
            <p>Email: ${studentInformationList[0].email}</p>
            <p>Username: ${studentInformationList[0].username}</p>
            <p>Sex: ${studentInformationList[0].sex}</p>

        </div>
    </div>

</div>
<div class="footer">Copyright&nbsp;&copy;&nbsp;602</div>
</body>
</html>

