<%--
  Created by IntelliJ IDEA.
  User: yebing
  Date: 2018/8/11
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<script>
    function logout() {
        window.location.href="/logout";
    }
</script>
<body>
<h2>Hello,Boy!</h2>
<button type="button" onclick="logout()">注销</button>
</body>
</html>
