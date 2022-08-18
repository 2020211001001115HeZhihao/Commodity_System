<%@ page import="com.example.commodity_system.Model.History" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_fac.jsp"%>

<h2 style="text-align: center">历史账单</h2><br>
<div class="searcha">
    <form action="Fac_historySearch" method="post">
        <div class="search">搜索类型</div>
        <div class="search">
            <select name="key">
                <option value="name">名称</option>
                <option value="type">类型</option>
                <option value="shop">商店</option>
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
<div style="text-align: center;margin-left: 100px">
    <table border="1px" cellspacing="0">
        <tr>
            <th style="width: 4em;">编号</th>
            <th style="width: 7em;">商品</th>
            <th style="width: 5em;">类型</th>
            <th style="width: 6em;">商店</th>
            <th style="width: 4em;">数量</th>
            <th style="width: 5em;">总价</th>
            <th style="width: 12em;">时间</th>
        </tr>
        <%
            List<History> list = (List<History>) request.getSession().getAttribute("his_all");
            int history_page = (int) request.getAttribute("fac_history_page");
            int list_len = list.size();
            int max_page = list_len / 15; if(!Objects.equals(list_len%15,0)) max_page = max_page + 1;
            List<History> ans = new ArrayList<>();
            int left = (history_page-1)*15; int right;
            if(left + 14 >= list_len) right = list_len-1;
            else right = left+14;
            for (int i = left ; i <= right;i++){
                ans.add(list.get(i));
            }
            request.setAttribute("ave",ans);
        %>
        <c:forEach items="${his_all}" var="proall">
            <tr>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 4em;" title="${proall.getHis_id()}">${proall.getHis_id()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 7em;" title="${proall.getHis_goodsname()}">${proall.getHis_goodsname()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 5em;" title="${proall.getHis_goodstype()}">${proall.getHis_goodstype()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 6em;" title="${proall.getHis_shopname()}">${proall.getHis_shopname()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="text-align: right;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 4em;" title="${proall.getHis_goodsnumber()}">${proall.getHis_goodsnumber()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="text-align: right;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 5em;" title="${proall.getHis_price()}">${proall.getHis_price()}</div></td>
                <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px"><div style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 12em;" title="${proall.getHis_time()}">${proall.getHis_time()}</div></td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
<style>
    .Shop_history_button{
        margin-left: 7px;
    }
</style>
<span style="margin-left: 110px">一共有<span style="color: #2727fd"><%=max_page%></span>页&nbsp;
        当前第<span style="color: #ff1414"><%=history_page%></span>页</span>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=factory&page=1'">首页</button>
<button class="Shop_history_button" onclick="prePage()">上一页</button>
<button class="Shop_history_button" onclick="nextPage()">下一页</button>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=factory&page=<%=max_page%>'">尾页</button>
<script type="text/javascript">
    var now_page = <%=history_page%>;
    var maxx = <%=max_page%>;
    function prePage(){
        if (now_page == 1) alert("已经是首页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=factory&page="+(now_page-1);
    }
    function nextPage(){
        if (now_page == maxx) alert("已经是尾页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=factory&page="+(now_page+1);
    }
</script>
<%@include file="footer.jsp"%>