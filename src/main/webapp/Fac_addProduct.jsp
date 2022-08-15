<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>

<h2 style="text-align: center">新增产品</h2><br>
<form action="Add_pro" method="post" style="text-align: center">
    <div class="input">产品名称 <input type="text" name="Pro_name" required="required"></div>
    <div class="input">产品类型 <input type="text" name="Pro_type" required="required"></div>
    <div class="input">产品价格 <input type="text" name="Pro_price" required="required"></div>
    <input type="submit" style="width: 100px;height: 30px;" value="确认"/>
</form>
<%@include file="footer.jsp"%>