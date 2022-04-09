<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>后台系统</title></head>
<body>
<li>您好:${ USER_SESSION.username }</li>
<li><a href="${ pageContext.request.contextPath }/logout">退出</a></li>
<li><a href="${ pageContext.request.contextPath }/orderinfo">
    订单信息</a></li>
</body>
</html>

