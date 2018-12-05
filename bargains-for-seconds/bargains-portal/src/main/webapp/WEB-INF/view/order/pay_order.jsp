<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="payOrder">
    商品名称：${bargains.title}
    购买数量：${productQuantity}
    支付总额：${payAmount}
    <input type="hidden" name="productId" value="${bargains.id}">
    <input type="hidden" name="userId" value="${userId}">
    <input type="hidden" name="merchantId" value="${bargains.merchantId}">
    <input type="hidden" name="payAmount" value="${payAmount}">
    <input type="hidden" name="productQuantity" value="${productQuantity}">
    <input type="hidden" name="stock" value="${bargains.stock}">

    收货人地址:<input type="text" name="receivingAdress"></br>
    收货人电话:<input type="text" name="receivingPhone"></br>
    收货人名称:<input type="text" name="receivingName"></br>
    <input type="button" value="订单提交" onclick="submit(this)"/>
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.sumbit();
    }
</script>
</html>