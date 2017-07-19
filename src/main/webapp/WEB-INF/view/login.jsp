<%--
  Created by IntelliJ IDEA.
  User: boxiaotong
  Date: 2017/2/9
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${error_msg}
<form action="/user/login" method="POST">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="确认"/>
</form>
</body>
</html>
