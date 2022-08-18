<%@ page import="com.example.commodity_system.Model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">招聘人员</h2><br>
    <div class="searcha">
        <form action="Shop_findWorkSearch?flag=1" method="post">
            <div class="search">搜索姓名</div>
            <div class="search">
                <input type="text" name="value" placeholder="请输入内容" maxlength="15">
            </div>
            <div class="search">
                <button type="submit">搜索</button>
            </div>
        </form>
    </div>
    <div style="text-align: center;margin-left: 75px">
        <table border="1px" cellspacing="0">
            <tr>
                <th width="75px">编号</th>
                <th width="200px">姓名</th>
                <th width="150px">电话</th>
                <th width="100px">性别</th>
                <th width="100px">地址</th>
                <th width="150px">操作</th>
            </tr>
            <c:forEach items="${searchSta_all}" var="proall">
                <tr>
                    <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px">${proall.getSta_id()}</td>
                    <td style="padding-left: 10px">${proall.getSta_name()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getSta_phone()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getSta_sex()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getSta_address()}</td>
                    <td style="text-align: center">
                        <button onclick="sta_for(${proall.getSta_id()})">招聘</button>
                        <button onclick="sta_del(${proall.getSta_id()})">拒绝</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<script type="text/javascript">
    function sta_for(x){
        var ans = x;
        if(confirm("您确认要招聘此人吗？")){
            location.href="${pageContext.request.contextPath}/Shop_findWork?flag=1&val="+ans;
        }
    }
    function sta_del(x){
        if(confirm("您确认拒绝应聘吗？")){
            var ans = x;
            location.href="${pageContext.request.contextPath}/Shop_findWork?flag=2&val="+ans;
        }
    }
</script>
<%@include file="footer.jsp"%>