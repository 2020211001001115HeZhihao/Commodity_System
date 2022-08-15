<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>

<h2 style="text-align: center">我的信息</h2><br>
<table border="0" style="text-align: center" width="500px">
    <tr><td>厂商编号</td><td>${fac_all.getFac_id()}</td></tr>
    <tr><td>厂商名称</td><td>${fac_all.getFac_name()}</td></tr>
    <tr><td>厂商地址</td><td>${fac_all.getFac_address()}</td></tr>
    <tr><td>老板姓名</td><td>${fac_all.getFac_boss()}</td></tr>
    <tr><td>老板电话</td><td>${fac_all.getFac_bossp()}</td></tr>
    <tr><td>厂商电话</td><td>${fac_all.getFac_phone()}</td></tr>
    <tr><td>厂商介绍</td><td>${fac_all.getFac_message()}</td></tr>
    <div style="text-align: right"><input type="button" onclick="location.href='Fac_change.jsp'" style="width: 100px;height: 30px;" value="修改信息"/></div>
</table>
<%@include file="footer.jsp"%>