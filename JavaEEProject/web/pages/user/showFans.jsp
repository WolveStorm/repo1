<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/29
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的粉丝</title>
</head>
<body>
粉丝总数:${sessionScope.count} <br/>
<c:forEach items="${sessionScope.followers}" var="Follower">
    <a href="http://localhost:8080/JavaEEProject/userServlet?action=showFollower&name=${Follower.name}">${Follower.name}</a> <br/>
</c:forEach>
</body>
</html>
