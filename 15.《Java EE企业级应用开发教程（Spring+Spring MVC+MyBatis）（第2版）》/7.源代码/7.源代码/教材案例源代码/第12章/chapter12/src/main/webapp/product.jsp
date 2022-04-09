<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>异步提交商品</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-3.6.0.js"></script>
</head>
<body>
<form id="products">
    <table border="1">
        <tr>
            <th>商品id</th>
            <th>商品名称</th>
            <th>提交</th>
        </tr>
        <tr>
            <td>
                <input name="proId" value="1" id="proId" type="text">
            </td>
            <td><input name="proName" value="三文鱼"
                       id="proName" type="text"></td>
            <td><input type="button" value="提交单个商品"
                       onclick="sumbmitProduct()"></td>
        </tr>
        <tr>
            <td><input name="proId" value="2" id="proId2"
                       type="text"></td>
            <td><input name="proName" value="红牛"
                       id="proName2" type="text"></td>
            <td><input type="button" value="提交多个商品"
                       onclick="submitProducts()"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function sumbmitProduct() {
        var proId = $("#proId").val();
        var proName = $("#proName").val();
        $.ajax({
            url: "${pageContext.request.contextPath }/getProduct",
            type: "post",
            data: JSON.stringify({proId: proId, proName: proName}),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (response) {
                alert(response);
            }
        });
    }

    function submitProducts() {
        var pro1 = {proId: $("#proId").val(), proName: $("#proName").val()}
        var pro2 = {proId: $("#proId2").val(), proName: $("#proName2").val()}
        $.ajax({
            url: "${pageContext.request.contextPath }/getProductList",
            type: "post",
            data: JSON.stringify([pro1, pro2]),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (response) {
                alert(response);
            }
        });
    }
</script>
</body>
</html>

