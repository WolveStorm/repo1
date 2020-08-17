<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/8/3
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="" language="java" %>
<html>
<head>
    <title>上传Excel文件</title>
</head>
<body>
<form action="http://localhost:8080/JavaEEProject/managerServlet?action=upLoad" method="post" enctype="multipart/form-data">
   Excel文件:  <input type="file" name="excel"> <br/>
    <input type="submit" value="提交文件">
</form>
</body>
</html>
