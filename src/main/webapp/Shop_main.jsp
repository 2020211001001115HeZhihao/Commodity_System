<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">我的商品</h2><br>
<div class="searcha">
    <form action="Shop_search" method="post">
        <div class="search">搜索类型</div>
        <div class="search">
            <select name="key">
                <option value="name">名称</option>
                <option value="type">类型</option>
                <option value="price">价格</option>
            </select>
        </div>
        <div class="search">
            <input type="text" name="value" placeholder="请输入内容" maxlength="15">
        </div>
        <div class="search">
            <button type="submit">搜索</button>
        </div>
        <div class="search">
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/Shop_addGoods_firstServlet'">进货</button>
        </div>
        <div class="search">
            <button type="button" onclick="location.href='#'">出货</button>
        </div>
    </form>
</div>


<%@include file="footer.jsp"%>