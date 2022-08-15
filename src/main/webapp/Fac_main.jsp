<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>
    <h2 style="text-align: center">我的产品</h2><br>
    <div class="searcha">
        <form action="Fac_search" method="post">
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
                <button type="button" onclick="location.href='Fac_addProduct.jsp'">新增产品</button>
            </div>
        </form>
    </div>
    <div>
        <table border="0" cellpadding="5" cellspacing="10">
            <thead>
                <tr>
                    <th width="40px">编号</th>
                    <th width="400px">名称</th>
                    <th width="100px">类型</th>
                    <th width="80px">价格</th>
                    <th width="100px">操作</th>
                </tr>
            </thead>
            <tbody class="table_1">
                <c:forEach items="${pro_all}" var="proall">
                    <tr>
                        <td style="padding-left: 5px">${proall.getPro_id()}</td>
                        <td style="padding-left: 10px">${proall.getPro_name()}</td>
                        <td style="padding-right: 10px;text-align: right">${proall.getPro_type()}</td>
                        <td style="padding-right: 10px;text-align: right">${proall.getPro_price()}</td>
                        <td style="text-align: center">
                            <button onclick="location.href='${pageContext.request.contextPath}/changeProServlet?id=${proall.getPro_id()}'">修改</button>
                            <button onclick="location.href='javascript:delpro(${proall.getPro_id()});'">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<%@include file="footer.jsp"%>