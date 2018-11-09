<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="updatemsproduct" method="post">
    <input name="id" value="${bargainsEntity.id }" type="hidden">
    商品id:<input name="productid" value="${bargainsEntity.productid }"></br>
    商品标题:<input name="producttitle" value="${bargainsEntity.producttitle }"></br>
    商品图片地址:<input name="productpicture" value="${bargainsEntity.productpicture }"></br>
    秒杀价格:<input name="miaoshaprice" value="${bargainsEntity.miaoshaprice }"></br>
    商品原价:<input name="originalprice" value="${bargainsEntity.originalprice }"></br>
    秒杀开始时间:<input name="starttimestring" value="${starttimestring }"></br>
    秒杀结束时间:<input name="endtimestring" value="${endtimestring}"></br>
    秒杀商品数量:<input name="productcount" value="${bargainsEntity.productcount }"></br>
    库存:<input name="stockcount" value="${bargainsEntity.stockcount }"></br>
    描述:<input name="description" value="${bargainsEntity.description }"></br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.sumbit();
    }
</script>
</html>