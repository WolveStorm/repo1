<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/28
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="userItem_edit.jsp">修改个人信息</a> <br/>
    个人信息<br/>
    昵称:${sessionScope.user.name} <br/>
    性别:${sessionScope.user.gentle} <br/>
    年龄:${sessionScope.user.age} <br/>
    <a href="../../index.jsp">回到主页</a>
</body>
</html>
