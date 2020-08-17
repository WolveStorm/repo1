<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/26
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<c:if test="${sessionScope.signal!=null}">
    您不是管理员，请登录管理员账号
</c:if>
<form action="http://localhost:8080/JavaEEProject/articleServlet?action=login" method="post">
    用户名:<input type="text" id="username" placeholder="请输入用户名" name="username"> <br/>
    密码:<input type="password" id="password" placeholder="请输入密码" name="password"> <br/>
    <input type="submit" value="提交" >
    
</form>
</body>
</html>
