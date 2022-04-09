<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单信息</title>
</head>
<body>
<form
        action="${pageContext.request.contextPath }/findOrderWithUser"
        method="post">
    所属用户：<input type="text" name="username"/><br/>
    订单编号：<input type="text" name="order.orderId"/><br/>
    <input type="submit" value="查询"/>
</form>
</body>
</html>

