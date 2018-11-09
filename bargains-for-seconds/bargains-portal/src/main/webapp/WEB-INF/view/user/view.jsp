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
    用户姓名:${userEntity.name }</br>
    用户账号:${userEntity.useraccount }</br>
    用户密码:${userEntity.userpassword }</br>
    用户性别:${userEntity.usersex }</br>
    用户年龄:${userEntity.userage }</br>
    用户地址:${userEntity.useraddress }</br>
    用户邮箱:${userEntity.useremail }</br>
</form>
</body>
</html>