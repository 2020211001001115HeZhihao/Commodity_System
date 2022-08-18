<%@ page import="com.example.commodity_system.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ArrayList" %>
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
    <div style="margin-left: 100px">
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
            <%
                List<Product> list = (List<Product>) request.getSession().getAttribute("pro_all");
                int addpro_page = (int) request.getAttribute("facmain_page");
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
            <tbody class="table_1">
                <c:forEach items="${ave}" var="proall">
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
    </div><br>
<style>
    .Shop_history_button{
        margin-left: 7px;
    }
</style>
<span style="margin-left: 110px">一共有<span style="color: #2727fd"><%=max_page%></span>页&nbsp;
        当前第<span style="color: #ff1414"><%=addpro_page%></span>页</span>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=facmain&page=1'">首页</button>
<button class="Shop_history_button" onclick="prePage()">上一页</button>
<button class="Shop_history_button" onclick="nextPage()">下一页</button>
<button class="Shop_history_button" onclick="location.href='${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=facmain&page=<%=max_page%>'">尾页</button>
<script type="text/javascript">
    var now_page = <%=addpro_page%>;
    var maxx = <%=max_page%>;
    function prePage(){
        if (now_page == 1) alert("已经是首页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=facmain&page="+(now_page-1);
    }
    function nextPage(){
        if (now_page == maxx) alert("已经是尾页");
        else window.location="${pageContext.request.contextPath}/HistoryServlet?fir=1&flag=facmain&page="+(now_page+1);
    }
</script>
<%@include file="footer.jsp"%>