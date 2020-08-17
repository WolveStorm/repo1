<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/3
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询文章</title>
</head>
<body>
请输入查找关键词：
<form method="post" action="http://localhost:8080/JavaEEProject/managerServlet?action=query">
    <input type="text" name="find" placeholder="请输入您想查找的关键词">
    <input type="submit" value="搜索">
</form>
</body>
</html>
