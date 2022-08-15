<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>

<h2 style="text-align: center">信息修改</h2><br>
<form action="Change_pro" method="post" style="text-align: center">
    <div class="input">商品名称 <input type="text" name="Pro_name" required="required" value="${changePro.getPro_name()}"></div>
    <div class="input">商品类型 <input type="text" name="Pro_type" value="${changePro.getPro_type()}"></div>
    <div class="input">商品价格 <input type="text" name="Pro_price" value="${changePro.getPro_price()}"></div>
   <input type="submit" style="width: 100px;height: 30px;" value="确认修改"/>
</form>
<%@include file="footer.jsp"%>