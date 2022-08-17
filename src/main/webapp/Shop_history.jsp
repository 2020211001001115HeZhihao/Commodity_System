<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">历史账单</h2><br>
<div class="searcha">
    <form action="Shop_historySearch" method="post">
        <div class="search">搜索类型</div>
        <div class="search">
            <select name="key">
                <option value="id">账单编号</option>
                <option value="name">名称</option>
                <option value="type">类型</option>
                <option value="factory">厂商</option>
                <option value="human">执行人</option>
            </select>
        </div>
        <div class="search">
            <input type="text" name="value" placeholder="请输入内容" maxlength="15">
        </div>
        <div class="search">
            <button type="submit">搜索</button>
        </div>
    </form>
</div>
<div style="text-align: center;margin-left: 40px">
    <table border="1px" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>商品</th>
            <th>类型</th>
            <th>厂商</th>
            <th>数量</th>
            <th>总价</th>
            <th>时间</th>
            <th>执行人</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${his_all}" var="proall">
            <tr>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 4em;" title="${proall.getHis_id()}">${proall.getHis_id()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 7em;" title="${proall.getHis_goodsname()}">${proall.getHis_goodsname()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 5em;" title="${proall.getHis_goodstype()}">${proall.getHis_goodstype()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 6em;" title="${proall.getHis_fromname()}">${proall.getHis_fromname()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="text-align: right;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 4em;" title="${proall.getHis_goodsnumber()}">${proall.getHis_goodsnumber()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="text-align: right;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 5em;" title="${proall.getHis_price()}">${proall.getHis_price()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 12em;" title="${proall.getHis_time()}">${proall.getHis_time()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 5em;" title="${proall.getHis_human()}">${proall.getHis_human()}</div></td>
                <c:if test="${proall.getHis_type() == 1}"><td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 3em;" title="进货">进货</div></td></c:if>
                <c:if test="${proall.getHis_type() == 2}"><td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 3em;" title="出货">出货</div></td></c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="footer.jsp"%>