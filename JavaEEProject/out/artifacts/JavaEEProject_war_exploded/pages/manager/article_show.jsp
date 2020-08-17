<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/3
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<a href="http://localhost:8080/JavaEEProject/managerServlet?action=deleteArticle">删除文章</a> <br/>
文章标题:${sessionScope.article.title} 文章作者:${sessionScope.article.author} 文章标签:${sessionScope.article.label}
<br/>文章内容:${sessionScope.article.context}<br/>
<a href="manager/index.jsp">回到主页</a>
</body>
</html>
