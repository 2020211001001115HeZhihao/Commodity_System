<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header_shop.jsp"%>

<h2 style="text-align: center">我的购物车</h2><br>
<c:if test="${empty(cart.getPromap())}">
    <h1 style="text-align: center">购物车为空！</h1>
</c:if>
<c:if test="${!empty(cart.getPromap())}">
    <div style="text-align: center;margin-left: 50px">
        <table border="1px" cellspacing="0">
            <tr>
                <th width="75px">编号</th>
                <th width="200px">名称</th>
                <th width="100px">类型</th>
                <th width="150px">厂商</th>
                <th width="155px">数量</th>
                <th width="100px">价格合计</th>
                <th width="100px">操作</th>
            </tr>
            <c:forEach items="${cart.getPromap()}" var="proall">
                <tr>
                    <td style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px">${proall.getKey()}</td>
                    <td style="padding-left: 10px">${proall.getValue().getProduct().getPro_name()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getValue().getProduct().getPro_type()}</td>
                    <td style="padding-right: 10px;text-align: right">${proall.getValue().getProduct().getPro_father2()}</td>
                    <td>
                        <input style="width: 20px;margin-left: 1px" type="button" value="-" id="${proall.getKey()}" onclick="updateNums(this)">
                        <input  style="text-align: center;width: 100px;" type="text" name="quantity"
                                value="${proall.getValue().getNumber()}"
                                oldVlue="${proall.getValue().getNumber()}" id="${proall.getKey()}"
                                onblur="update(this.value,this.id,this.oldValue)">
                        <input style="width: 20px" type="button" value="+" id="${proall.getKey()}" onclick="updateNums(this)">
                    </td>
                    <td style="padding-right: 10px;text-align: right">${proall.getValue().getPrice()}</td>
                    <td style="text-align: center"><button onclick="location.href='Shop_addCartdeleteServlet?id=${proall.getKey()}'">删除</button></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2" style="text-align: center">合计：</td>
                <td colspan="2" style="text-align: center">${cart.getPrice()}</td>
            </tr>
        </table>
        <div style="text-align: center;margin-top: 10px">
            <button onclick="location.href='${pageContext.request.contextPath}/Shop_addGoods_firstServlet'">继续购物</button>
            <button onclick="location.href='${pageContext.request.contextPath}/Shop_addCartFinishServlet'">完成</button>&nbsp;<span style="color: red">${add_message}</span>
        </div>
    </div>
</c:if>
<script type="text/javascript">
    function update(value,id,oldValue) {

        //获取得到输入框的数据
        var quantity = value;

        //询问用户是否真的修改
        var b = window.confirm("你确定修改吗？");

        //如果确定修改，就跳转到修改的Servlet上
        if(b) {
            window.location.href = "${pageContext.request.contextPath}/Shop_addCartupdateQuantity?id=" + id + "&quantity=" + quantity + "";
        }else {
            //如果不确定修改，把输入框的数据改成是原来的
            input.value = oldValue;
        }
    }
    function updateNums(object) {
        var symbol= object.value;
        if (symbol=="+"){
            window.location.href="${pageContext.request.contextPath}/Shop_addCartupdateNumsServlet?id="+object.id+"&symbol=add";
        }else if (symbol=="-"){
            window.location.href="${pageContext.request.contextPath}/Shop_addCartupdateNumsServlet?id="+object.id+"&symbol=sub";
        }
    }
</script>
<%@include file="footer.jsp"%>