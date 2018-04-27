<%--
  Created by IntelliJ IDEA.
  User: yuankanfang
  Date: 4/25/18
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome, Please Login:</h1>
<form action="login" method ="post">
name: <input type="text" name="loginName" width="30"/>
    passward: <input type="text" name="password" width="30" />
    <input type="submit" value="login"/>


</form>

<p style="color:red"> ${errorMessage}</p>
</body>
</html>
