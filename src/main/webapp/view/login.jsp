<%--
  Created by IntelliJ IDEA.
  User: yebing
  Date: 2018/8/11
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/checkLogin" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <button type="submit">登录</button>
</form>
</body>
</html>
