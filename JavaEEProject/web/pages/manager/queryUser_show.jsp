<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/3
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<a href="http://localhost:8080/JavaEEProject/managerServlet?action=deleteUser">删除该用户</a> <br/>
用户昵称:${sessionScope.FindUser.name} <br/>
用户年龄:${sessionScope.FindUser.age} <br/>
用户性别:${sessionScope.FindUser.gentle}
</body>
</html>
</body>
</html>
