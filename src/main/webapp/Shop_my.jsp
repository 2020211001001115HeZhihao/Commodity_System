<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">我的信息</h2><br>
<table border="0" style="text-align: center" width="500px">
    <tr><td>商家编号</td><td>${shop_all.getShop_id()}</td></tr>
    <tr><td>商店名称</td><td>${shop_all.getShop_name()}</td></tr>
    <tr><td>商店地址</td><td>${shop_all.getShop_address()}</td></tr>
    <tr><td>老板姓名</td><td>${shop_all.getShop_boss()}</td></tr>
    <tr><td>老板电话</td><td>${shop_all.getShop_bossp()}</td></tr>
    <tr><td>商店电话</td><td>${shop_all.getShop_phone()}</td></tr>
    <tr><td>商店介绍</td><td>${shop_all.getShop_message()}</td></tr>
    <tr><td>商店资金</td><td>${shop_all.getShop_money()}</td></tr>
    <div style="text-align: right"><input type="button" onclick="location.href='Shop_change.jsp'" style="width: 100px;height: 30px;" value="修改信息"/></div>
</table>
<%@include file="footer.jsp"%>