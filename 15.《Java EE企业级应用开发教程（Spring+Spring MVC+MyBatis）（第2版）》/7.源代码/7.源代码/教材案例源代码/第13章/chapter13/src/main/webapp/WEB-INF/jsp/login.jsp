<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>用户登录</title></head>
<body>
<form action="${pageContext.request.contextPath }/login"
      method="POST">
    <div>${msg}</div>
    用户名：<input type="text" name="username"/><br/>
    密&nbsp;&nbsp;码：
    <input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>

