<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/28
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
查询结果<br/>
<c:forEach items="${sessionScope.articles}" var="article">
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=queryShow&title=${article.title}&author=${article.author}&label=${article.label}" >标题:${article.title} 作者:${article.author} 标签:${article.label}</a><br/>
</c:forEach>
</body>
</html>
