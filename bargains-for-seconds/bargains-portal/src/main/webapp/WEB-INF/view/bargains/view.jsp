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
    秒杀商品的id: ${bargains.productId }</br>
    秒杀商品的标题: ${bargains.title }</br>
    秒杀商品的图片地址: ${bargains.picture }</br>
    秒杀商品价格: ${bargains.bargainsPrice }</br>
    商家的id: ${bargains.merchantId }</br>
    商品原价: ${bargains.originalPrice }</br>
    秒杀商品的申请时间: ${bargains.applyDate }</br>
    秒杀商品的审核时间: ${bargains.auditStatus }</br>
    秒杀的开始时间: ${bargains.startTime }</br>
    秒杀的结束时间: ${bargains.endTime }</br>
    秒杀数量: ${bargains.productQauntity }</br>
    秒杀的库存: ${bargains.stock }</br>
    秒杀的描述: ${bargains.description }</br>
</form>
</body>
</html>