<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商品管理系统</title>
    <link href="css/main_style.css" rel="stylesheet">
    <link href="css/search_style.css" rel="stylesheet">
</head>
<body>
<div class="header">
    商品管理系统
    <h4>
        欢迎您，${sta_all.getSta_name()}
    </h4>
</div>
<div class="container1">
    <div class="row1">
        <div class="runoob-col-md2">
            <div class="sidebar-box">
                <div class="tab">
                    <span>功能一览</span>
                </div>
                <div class="design">
                    <a href="Sta_my.jsp" >我的信息</a>
                    <c:if test="${sta_all.getSta_shop() != 0}">
                        <a href="Shop_main.jsp" >商品展示</a>
                        <a href="${pageContext.request.contextPath}/HistoryServlet?fir=0&flag=shop&page=1" >账单查询</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/Sta_findWorkSearch?flag=0" >寻找工作</a>
                    <a href="exit.jsp" >退出账号</a>
                </div>
            </div>
        </div>
        <div class="middle-column">
            <div class="article">
                <div class="article-body">