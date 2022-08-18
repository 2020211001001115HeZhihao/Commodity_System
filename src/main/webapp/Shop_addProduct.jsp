<%@ page import="com.example.commodity_system.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ArrayList" %>
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
        <%
            List<Product> list = (List<Product>) request.getSession().getAttribute("addGoods");
            int addpro_page = (int) request.getAttribute("add_pro_page");
            int list_len = list.size();
            int max_page = list_len / 15; if(!Objects.equals(list_len%15,0)) max_page = max_page + 1;
            List<Product> ans = new ArrayList<>();
            int left = (addpro_page-1)*15; int right;
            if(left + 14 >= list_len) right = list_len-1;
            else right = left+14;
            for (int i = left ; i <= right;i++){
                ans.add(list.get(i));
            }
            request.setAttribute("ave",ans);
        %>
        <c:forEach items="${ave}" var="proall">
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
</div><br>
<style>
    .Shop_history_button{
        margin-left: 7px;
    }
</style>
<span style="margin-left: 50px">一共有<span style="color: #2727fd"><%=max_page%></span>页&nbsp;
        当前第<span style="color: #ff1414"><%=addpro_page%></span>页</span>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=addProduct&page=1'">首页</button>
<button class="Shop_history_button" onclick="prePage()">上一页</button>
<button class="Shop_history_button" onclick="nextPage()">下一页</button>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=addProduct&page=<%=max_page%>'">尾页</button>
<script type="text/javascript">
    var now_page = <%=addpro_page%>;
    var maxx = <%=max_page%>;
    function prePage(){
        if (now_page == 1) alert("已经是首页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=addProduct&page="+(now_page-1);
    }
    function nextPage(){
        if (now_page == maxx) alert("已经是尾页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=addProduct&page="+(now_page+1);
    }
</script>
<%@include file="footer.jsp"%>