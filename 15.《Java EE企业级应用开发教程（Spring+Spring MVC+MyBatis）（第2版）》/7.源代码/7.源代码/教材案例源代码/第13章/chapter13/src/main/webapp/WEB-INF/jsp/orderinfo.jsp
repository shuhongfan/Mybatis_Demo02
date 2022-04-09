<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>订单信息</title></head>
<body>
您好:${ USER_SESSION.username }
<a href="${ pageContext.request.contextPath }/logout">退出</a>
<table border="1" width="80%">
    <tr align="center">
        <td colspan="2">订单id:D001</td>
    </tr>
    <tr align="center">
        <td>商品Id</td>
        <td>商品名称</td>
    </tr>
    <tr align="center">
        <td>P001</td>
        <td>三文鱼</td>
    </tr>
    <tr align="center">
        <td>P002</td>
        <td>红牛</td>
    </tr>
</table>
</body>
</html>

