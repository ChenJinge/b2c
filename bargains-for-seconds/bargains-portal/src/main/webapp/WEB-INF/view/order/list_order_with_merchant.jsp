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
<table border="2">
    <tr>
        <td>支付金额</td>
        <td>订单生成时间</td>
        <td>支付转态</td>
        <td>收货人地址</td>
        <td>收货人电话</td>
        <td>收货人名称</td>
        <td>交易流水号</td>
        <td>购买数量</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.payAmount }</td>
            <td>${item.createTime }</td>
            <td>${item.payStatus }</td>
            <td>${item.receivingAdress }</td>
            <td>${item.receivingPhone }</td>
            <td>${item.receivingName }</td>
            <td>${item.tradeSerialNumber }</td>
            <td>${item.num }</td>
            <td><c:if test="${item.payStatus == 1 }">未支付</c:if><c:if test="${item.payStatus == 2 }">支付完成</c:if><c:if
                    test="${item.payStatus == 3 }">退款成功</c:if>
                <c:if test="${item.payStatus == 4 }"><a href="javascript:void"
                                                        onclick="applyrefund('${item.tradeSerialNumber}','${item.payAmount}','${item.id}','${item.payType}','3')">退款审核通过</a>||<a href="javascript:void" onclick="applyrefund('${item.tradeSerialNumber}','${item.payAmount}','${item.id}','${item.payType}','5')">退款审核不通过</a></c:if>
                <c:if test="${item.payStatus == 5 }">退款申请不成功</c:if></td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">

    function applyrefund(tradeSerialNumber, payAmount, orderId, payType, payStatus) {
        window.location.href = "auditRefund?tradeSerialNumber=" + tradeSerialNumber + "&&payAmount=" + payAmount + "&&orderId=" + orderId + "&&payType=" + payType + "&&payStatus=" + payStatus;
    }
</script>
</body>
</html>