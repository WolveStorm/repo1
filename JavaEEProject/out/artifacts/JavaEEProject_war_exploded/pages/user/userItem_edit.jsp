<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/28
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<form action="http://localhost:8080/JavaEEProject/userServlet?action=updateItem" method="post">
    昵称:<input type="text" id="name" name="name" placeholder="${sessionScope.user.name}">
    性别:<input type="text" id="sex" name="sex" placeholder="${sessionScope.user.gentle}">
    年龄:<input type="text" id="age" name="age" placeholder="${sessionScope.user.age}">
    <input type="submit" value="修改">
</form>
</body>
</html>
