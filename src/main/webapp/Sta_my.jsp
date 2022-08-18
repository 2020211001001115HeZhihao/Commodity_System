<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_sta.jsp"%>

<h2 style="text-align: center">我的信息</h2><br>
<table border="0" style="text-align: center" width="500px">
    <tr><td>员工编号</td><td>${sta_all.getSta_id()}</td></tr>
    <tr><td>员工姓名</td><td>${sta_all.getSta_name()}</td></tr>
    <tr><td>员工电话</td><td>${sta_all.getSta_phone()}</td></tr>
    <tr><td>员工性别</td><td>${sta_all.getSta_sex()}</td></tr>
    <tr><td>员工地址</td><td>${sta_all.getSta_address()}</td></tr>
    <tr><td>员工介绍</td><td>${sta_all.getSta_message()}</td></tr>
    <div style="text-align: right"><input type="button" onclick="location.href='Sta_change.jsp'" style="width: 100px;height: 30px;" value="修改信息"/></div>
</table>
<%@include file="footer.jsp"%>