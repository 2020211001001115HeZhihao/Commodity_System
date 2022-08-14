<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>login</title>
    <link href="css/login_style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="login-box">
        <div id="login-title">
            商品管理系统
        </div>
        <form action="index_login" method="post">
            <div class="input">
                <input type="text" placeholder="输入你的账号" name="username" required="required">
            </div>
            <div class="input">
                <input type="password" placeholder="输入你的密码" name="password" required="required">
            </div>

            <div id="login" style="text-align: center">
                <input type="submit" value="登录"/>
            </div>

            <div id="register">
                <input type="button" value="没有账号？点我注册" onclick="location.href='register.jsp'" />
            </div>
        </form>
    </div>
</div>
</body>
</html>