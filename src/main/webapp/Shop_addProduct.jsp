<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">进货</h2><br>
<div class="searcha">
    <form action="Shop_addsearch" method="post">
        <div class="search">搜索类型</div>
        <div class="search">
            <select name="key">
                <option value="name">名称</option>
                <option value="type">类型</option>
                <option value="price">价格</option>
                <option value="factory">厂商</option>
            </select>
        </div>
        <div class="search">
            <input type="text" name="value" placeholder="请输入内容" maxlength="15">
        </div>
        <div class="search">
            <button type="submit">搜索</button>
        </div>
        <div class="search">
            <button type="button" onclick="location.href='Shop_addListCart.jsp'">购物车</button>
        </div>
    </form>
</div>
<div style="text-align: center;margin-left: 50px">
    <table border="1px" cellspacing="0">
        <tr>
            <th width="75px">编号</th>
            <th width="200px">名称</th>
            <th width="100px">类型</th>
            <th width="150px">厂商</th>
            <th width="100px">单价</th>
            <th width="150px">添加到购物车</th>
        </tr>
        <c:forEach items="${addGoods}" var="proall">
            <tr>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px">${proall.getPro_id()}</td>
                <td style="padding-left: 10px">${proall.getPro_name()}</td>
                <td style="padding-right: 10px;text-align: right">${proall.getPro_type()}</td>
                <td style="padding-right: 10px;text-align: right">${proall.getPro_father2()}</td>
                <td style="padding-right: 10px;text-align: right">${proall.getPro_price()}</td>
                <td style="text-align: center">
                    <button onclick="location.href='${pageContext.request.contextPath}/Shop_addCartServlet?id=${proall.getPro_id()}'">加入购物车</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="footer.jsp"%>