<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
    <input name="id" value="${user.id }" type="hidden"/>
    用户姓名:<input name="name" value="${user.name }"></br>
    用户账号:<input name="account" value="${user.account }"></br>
    用户密码:<input name="password" value="${user.password }"></br>
    用户性别:<input name="sex" value="${user.sex }"></br>
    用户年龄:<input name="age" value="${user.age }"></br>
    用户的地址:<input name="address" value="${user.address}"></br>
    用户的邮箱:<input name="email" value="${user.email }"></br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.sumbit();
    }
</script>
</html>