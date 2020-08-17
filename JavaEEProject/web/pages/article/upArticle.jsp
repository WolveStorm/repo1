<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/7/2
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文章</title>
</head>
<body>
<form action="http://localhost:8080/JavaEEProject/articleServlet?action=upLoad" method="post">
    文章标题:<input type="text" name="title"><br/>
    文章作者:<input type="text" name="author"><br/>
    文章标签:<input type="text" name="label"><br/>
    文章内容:<br/><textarea rows="40" cols="40" name="context"></textarea><br/>
    <input type="submit" value="提交">
</form>


</form>
</body>
</html>
