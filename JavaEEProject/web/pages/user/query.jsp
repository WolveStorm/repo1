<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/29
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
</head>
<body>
<form method="post" action="http://localhost:8080/JavaEEProject/userServlet?action=query">
    <input type="text" name="find" placeholder="请输入您想查找的关键词">
    <input type="submit" value="搜索">
</form>

</body>
</html>
