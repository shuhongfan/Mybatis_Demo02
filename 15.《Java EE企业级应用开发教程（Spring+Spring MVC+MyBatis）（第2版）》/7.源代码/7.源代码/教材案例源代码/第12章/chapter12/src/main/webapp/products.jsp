<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>提交商品</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/getProducts"
      method="post">
    <table width="220px" border="1">
        <tr>
            <td>选择</td>
            <td>商品名称</td>
        </tr>
        <tr>
            <td>
                <input name="proIds" value="1" type="checkbox">
            </td>
            <td>Java基础教程</td>
        </tr>
        <tr>
            <td>
                <input name="proIds" value="2" type="checkbox">
            </td>
            <td>JavaWeb案例</td>
        </tr>
        <tr>
            <td>
                <input name="proIds" value="3" type="checkbox">
            </td>
            <td>SSM框架实战</td>
        </tr>
    </table>
    <input type="submit" value="提交商品"/>
</form>
</body>
</html>

