<%@ page import="pojo.Follower" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/2
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>

昵称:${sessionScope.follower.name} <br/>
性别:${sessionScope.follower.gentle} <br/>
年龄:${sessionScope.follower.age} <br/>
<a href="index.jsp">回到主页</a>
</body>
</html>
