<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>

<h2 style="text-align: center">信息修改</h2><br>
<form action="Change_fac" method="post" style="text-align: center">
    <div class="input">厂商名称 <input type="text" name="Fac_name" required="required" value="${fac_all.getFac_name()}"></div>
    <div class="input">厂商地址 <input type="text" name="Fac_address" value="${fac_all.getFac_address()}"></div>
    <div class="input">老板姓名 <input type="text" name="Fac_boss" value="${fac_all.getFac_boss()}"></div>
    <div class="input">老板电话 <input type="text" name="Fac_bossp" value="${fac_all.getFac_bossp()}"></div>
    <div class="input">厂商电话 <input type="text" name="Fac_phone" value="${fac_all.getFac_phone()}"></div>
    <div class="input">厂商介绍 <input type="text" name="Fac_message" value="${fac_all.getFac_message()}"></div>
    <input type="submit" style="width: 100px;height: 30px;" value="确认修改"/>
</form>
<%@include file="footer.jsp"%>