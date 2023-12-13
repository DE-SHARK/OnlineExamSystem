<%--
  Created by IntelliJ IDEA.
  User: c~java
  Date: 2023/11/12
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>注册界面</title>
    <script src="./js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#username").blur(function(){
                var username=$(this).val();
                $.get("/Checkusername","username="+username,function(rs){
                    $("#response").html(rs)
                });
            });
        })
    </script>
    <style>
        #response{
            color: #af2828;
        }
    </style>
</head>
<body>
<% String error = request.getParameter("error");
    if (error != null){    %>
<p style="color: red;"><%= error %></p>
<%    }    %>

<form action="xizhehong/RegisterServlet" method="post">
    <table>
        <tr>
            <td>用户</td>
            <td colspan="2">  <input type="text" name="username" id="username"><span id = response></span>      </td>
        </tr>

        <tr>
            <td>密码</td>
            <td colspan="2">   <input type="password" name="password">     </td>
        </tr>

        <tr>
            <td>确认密码</td>
            <td colspan="2">   <input type="password" name="password1">     </td>
        </tr>

        <tr>
            <td>  <input type="submit" value="注册">  </td>
            <td>  <input type="reset" value="重置">  </td>
        </tr>
    </table>
</form>
    <script>

    </script>
</body>
</html>
