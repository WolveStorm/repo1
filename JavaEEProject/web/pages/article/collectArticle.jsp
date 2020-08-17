<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/3
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏文章</title>
</head>
<body>
<c:forEach items="${sessionScope.collectArticles}" var="article">
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=ToCollectPage&id=${article.id}">${article.title}</a> <br/>
</c:forEach>
<br/>
<a href="index.jsp">回到主页</a>
</body>
</html>
