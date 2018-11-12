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
    秒杀商品的id: ${bargainsEntity.productid }</br>
    秒杀商品的标题: ${bargainsEntity.producttitle }</br>
    秒杀商品的图片地址: ${bargainsEntity.productpicture }</br>
    秒杀商品价格: ${bargainsEntity.miaoshaprice }</br>
    商家的id: ${bargainsEntity.msmerchantid }</br>
    商品原价: ${bargainsEntity.originalprice }</br>
    秒杀商品的申请时间: ${bargainsEntity.applydate }</br>
    秒杀商品的审核时间: ${bargainsEntity.auditstate }</br>
    秒杀的开始时间: ${bargainsEntity.starttime }</br>
    秒杀的结束时间: ${bargainsEntity.endtime }</br>
    秒杀数量: ${bargainsEntity.productcount }</br>
    秒杀的库存: ${bargainsEntity.stockcount }</br>
    秒杀的描述: ${bargainsEntity.description }</br>
</form>
</body>
</html>