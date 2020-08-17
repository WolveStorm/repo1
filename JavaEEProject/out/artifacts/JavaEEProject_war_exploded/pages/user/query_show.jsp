<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/29
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<c:if test="${sessionScope.flag!=null}">
    <a href="http://localhost:8080/JavaEEProject/userServlet?action=deleteFollow">取消关注</a> <br/>
</c:if>
<c:if test="${sessionScope.flag==null}">
    <a href="http://localhost:8080/JavaEEProject/userServlet?action=follow">关注</a> <br/>
</c:if>

用户昵称:${sessionScope.FindUser.name} <br/>
用户年龄:${sessionScope.FindUser.age} <br/>
用户性别:${sessionScope.FindUser.gentle}
</body>
</html>
