<%--
  Created by IntelliJ IDEA.
  User: 89255
  Date: 2020/6/26
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<script type="text/javascript" src="../jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(function () {
        $(".sex").click(function () {
            var value = $('input[name="sex"]:checked').val();
            alert(value)
        })
    })
</script>

<form action="http://localhost:8080/JavaEEProject/articleServlet?action=regist" method="post">
    昵称：<input type="text" id="name" placeholder="请输入昵称" name="name"> <br/>
    用户名:<input type="text" id="username" placeholder="请输入用户名" name="username"> <br/>
    密码:<input type="password" id="password1" placeholder="请输入密码" name="password1"> <br/>
    再次输入:<input type="password" id="password2" placeholder="请输入密码" name="password2"> <br/>
    年龄:<input type="text" id="age" placeholder="请输入年龄" name="age"> <br/>
    性别：<input type="radio" value="男"  class="sex" name="sex">男 <input name="sex" type="radio" value="女"  class="sex">女<br/>
    <input type="submit" value="提交" >
</form>
</body>
</html>
