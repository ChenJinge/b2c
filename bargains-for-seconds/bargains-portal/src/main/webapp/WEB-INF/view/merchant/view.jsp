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
    商家的姓名:${merchant.name }</br>
    商家的店铺名称:${merchant.shopName }</br>
    商家账号:${merchant.account }</br>
    商家密码:${merchant.password }</br>
    商家经营范围:${merchant.runScope }</br>
</form>
</body>
</html>