<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center><a href="toApplyBargains">申请秒杀商品</a></center>
<table border="2">
    <tr>
        <td>商品id</td>
        <td>商品标题</td>
        <td>图片地址</td>
        <td>秒杀价格</td>
        <td>商家id</td>
        <td>秒杀原价</td>
        <td>申请时间</td>
        <td>状态</td>
        <td>秒杀开始时间</td>
        <td>秒杀结束时间</td>
        <td>秒杀商品数</td>
        <td>库存</td>
        <td>商品描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.productId }</td>
            <td>${item.title }</td>
            <td><img src="${item.picture }" style="width:100px;" ></td>
            <td>${item.bargainsPrice }</td>
            <td>${item.merchantId }</td>
            <td>${item.originalPrice }</td>
            <td>${item.applyDate }</td>
            <td>${item.auditStatus }</td>
            <td>${item.startTime }</td>
            <td>${item.endTime }</td>
            <td>${item.count }</td>
            <td>${item.stock }</td>
            <td>${item.description }</td>
            <td>
                <a href="toUpdateBargains?id=${item.id}">修改</a>||
                <a href="deleteBargainsById?id=${item.id}">删除</a>||
                <a href="/bargains/queryBargainsById?id=${item.id}">查看</a>||
                <a href="/bargains/toUpdateBargainsAuditStatus?id=${item.id}">审核</a>||
                <a href="/product/toAddProduct?productId=${item.id}&merchantId=${item.merchantId}">添加商品详情</a>||
                <a href="/product/queryProductById?productId=${item.id}">查看商品详情</a>||
                <a href="/product/toUpdateProduct?productId=${item.id}">修改商品详情</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>