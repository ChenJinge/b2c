<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
欢迎：<span id="useraccount"></span>
<a href="/login/toRegister">注册</a></br>
<a href="/login/toLogin">登录</a>
<a href="/login/exit">退出登录</a>
<a href="/order/queryOrderByUserId">订单查询</a>
<table border="2">
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.title}</td>
            <td>${item.picture}</td>
            <td>${item.bargainsPrice}</td>
            <td>${item.originalPrice}</td>
            <td>${item.startTime}</td>
            <td>${item.endTime}</td>
            <td><a href="viewProduct?id=${item.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type: "get",
        url: "/pageHome/getUser",
        success: function (msg) {
            $("#useraccount").html(msg);
        }
    });

</script>
</body>
</html>