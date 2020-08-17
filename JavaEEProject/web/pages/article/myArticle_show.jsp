<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/2
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的文章</title>
</head>
<body>

<c:forEach items="${sessionScope.myArticles}" var="article">
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=myArticleShow&title=${article.title}&author=${article.author}&label=${article.label}">标题:${article.title}</a><br/>
</c:forEach>
</body>
</html>
