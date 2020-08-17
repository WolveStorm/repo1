<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/8/3
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载excel</title>
</head>
<body>
<form action="http://localhost:8080/JavaEEProject/articleServlet?action=download" method="post">
    <input type="submit" value="下载">
</form>
</body>
</html>
