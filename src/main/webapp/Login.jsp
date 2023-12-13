<%--
  Created by IntelliJ IDEA.
  User: c~java
  Date: 2023/11/11
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<% String message = request.getParameter("error");
    if (message != null){    %>
<p style="color: red;"><%= message %></p>
<%    }    %>

<form action="LoginServlet" method="post">
    <table>
        <tr>
            <td>用户</td>
            <td colspan="3">  <input type="text" name="username">      </td>
        </tr>

        <tr>
            <td>密码</td>
            <td colspan="3">   <input type="password" name="password">     </td>
        </tr>

        <tr>
            <td>验证码</td>
            <td colspan="2">    <input type="text" name="yanzhengma">      </td>
            <td>  <img src="AuthCode" id="image">  </td>
        </tr>

        <tr>
            <td>  <input type="submit" value="登录">  </td>
            <td>  <input type="reset" value="重置">  </td>
        </tr>
    </table>
</form>

<form action="Register.jsp" method="post">
    <table>
        <tr><td>  <input type="submit" value="注册">  </td></tr>
    </table>
</form>
</body>
</html>
