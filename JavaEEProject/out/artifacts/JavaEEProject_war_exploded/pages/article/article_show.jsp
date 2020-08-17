<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/2
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章</title>
</head>
<body>
<c:if test="${sessionScope.method==1}">
<c:if test="${sessionScope.sign==null}">
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=collect">收藏文章</a> <br/>
</c:if>
<c:if test="${sessionScope.sign!=null}">
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=deleteCollect">取消收藏文章</a> <br/>
</c:if>
</c:if>
<c:if test="${sessionScope.method==2}">
    <c:if test="${sessionScope.f==null}">
        <a href="http://localhost:8080/JavaEEProject/articleServlet?action=collect">收藏文章</a> <br/>
    </c:if>
    <c:if test="${sessionScope.f!=null}">
        <a href="http://localhost:8080/JavaEEProject/articleServlet?action=deleteCollect">取消收藏文章</a> <br/>
    </c:if>
</c:if>
文章标题:${sessionScope.article.title} 文章作者:${sessionScope.article.author} 文章标签:${sessionScope.article.label}
<br/>文章内容:${sessionScope.article.context}<br/>
<a href="index.jsp">回到主页</a>
</body>
</html>
