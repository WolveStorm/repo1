<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/26
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
  <c:if test="${sessionScope.user!=null}">
    <a href="pages/user/userItem.jsp">个人信息</a>  <br/>
    <a href="http://localhost:8080/JavaEEProject/userServlet?action=showFans">我的粉丝</a>  <br/>
    <a href="pages/article/query.jsp">查询文章</a>  <br/>
    <a href="pages/user/query.jsp">查询用户</a> <br/>
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=myArticle">我的文章 </a> <br/>
    <a href="pages/article/upArticle.jsp">发布文章</a>  <br/>
    <a href="http://localhost:8080/JavaEEProject/articleServlet?action=showCollect">收藏文章 </a> <br/>
    <a href="pages/article/download.jsp">下载excel</a>
  </c:if>
  <c:if test="${sessionScope.user==null}">
    请先登录<a href="pages/user/login.jsp"><br/>登陆链接</a><br/>
    <a href="pages/user/regist.jsp">注册连接</a>
  </c:if>
  </body>
</html>
