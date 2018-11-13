<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="add">
    用户姓名:${user.name }</br>
    用户账号:${user.account }</br>
    用户密码:${user.password }</br>
    用户性别:${user.sex }</br>
    用户年龄:${user.age }</br>
    用户地址:${user.address }</br>
    用户邮箱:${user.email }</br>
</form>
</body>
</html>