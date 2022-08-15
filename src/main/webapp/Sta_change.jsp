<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_sta.jsp"%>

<h2 style="text-align: center">信息修改</h2><br>
<form action="Change_sta" method="post" style="text-align: center">
    <div class="input">员工姓名 <input type="text" name="Sta_name" required="required" value="${sta_all.getSta_name()}"></div>
    <div class="input">员工电话 <input type="text" name="Sta_phone" value="${sta_all.getSta_phone()}"></div>
    <div class="input">员工性别 <input type="text" name="Sta_sex" value="${sta_all.getSta_sex()}"></div>
    <div class="input">员工地址 <input type="text" name="Sta_address" value="${sta_all.getSta_address()}"></div>
    <div class="input">员工介绍 <input type="text" name="Sta_message" value="${sta_all.getSta_message()}"></div>
    <input type="submit" style="width: 100px;height: 30px;" value="确认修改"/>
</form>
<%@include file="footer.jsp"%>