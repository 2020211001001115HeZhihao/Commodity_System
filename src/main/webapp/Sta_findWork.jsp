<%@ page import="com.example.commodity_system.Dao.StaDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_sta.jsp"%>

<h2 style="text-align: center">寻找工作</h2><br>
<c:if test="${sta_all.getSta_shop() != 0}">
    <h1 style="text-align: center">您已经入职！</h1>
</c:if>
<c:if test="${sta_all.getSta_shop() == 0}">
    <div class="searcha">
        <form action="Sta_findWorkSearch?flag=1" method="post">
            <div class="search">搜索名称</div>
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
                <th width="200px">名称</th>
                <th width="100px">地址</th>
                <th width="150px">电话</th>
                <th width="100px">老板</th>
                <th width="100px">应聘</th>
            </tr>
            <c:forEach items="${searchShop_all}" var="proall">
                <tr>
                    <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px">${proall.getShop_id()}</td>
                    <td style="padding-left: 10px">${proall.getShop_name()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getShop_address()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getShop_phone()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getShop_boss()}</td>
                    <td style="text-align: center">
                        <button onclick="sta_ask(${proall.getShop_id()})">应聘</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<script type="text/javascript">
    function sta_ask(x){
        var a_shopid = x;
        var a_staid = ${staff_id};
        if(confirm("您确认要应聘此商店吗？")){
            window.location="${pageContext.request.contextPath}/Sta_findWorkButton?shop="+a_shopid+"&sta="+a_staid;
        }
    }
</script>
<%@include file="footer.jsp"%>