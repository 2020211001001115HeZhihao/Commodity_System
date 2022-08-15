<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

    <h2 style="text-align: center">信息修改</h2><br>
    <form action="Change_shop" method="post" style="text-align: center">
        <div class="input">商店名称 <input type="text" name="Shop_name" required="required" value="${shop_all.getShop_name()}"></div>
        <div class="input">商店地址 <input type="text" name="Shop_address" value="${shop_all.getShop_address()}"></div>
        <div class="input">老板姓名 <input type="text" name="Shop_boss" value="${shop_all.getShop_boss()}"></div>
        <div class="input">老板电话 <input type="text" name="Shop_bossp" value="${shop_all.getShop_bossp()}"></div>
        <div class="input">商店电话 <input type="text" name="Shop_phone" value="${shop_all.getShop_phone()}"></div>
        <div class="input">商店介绍 <input type="text" name="Shop_message" value="${shop_all.getShop_message()}"></div>
        <div class="input">商店资金 <input type="text" name="Shop_money" required="required" value="${shop_all.getShop_money()}"></div>
        <input type="submit" style="width: 100px;height: 30px;" value="确认修改"/>
    </form>
<%@include file="footer.jsp"%>