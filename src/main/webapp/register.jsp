<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>register</title>
    <link href="css/login_style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <div class="register-box">
        <div id="register-title">
        注册
        </div>
        <form action="index_register" method="post">
            <div class="input">
                <input type="text" required="required" placeholder="创造你的账号" name="userName-1">
            </div>
            <div class="input">
                <input type="text" required="required" placeholder="创造你的密码" name="password-1">
            </div>
            <div id="radioA">
                <input type="radio" name="type" value="1" required="required">商家&nbsp;
                <input type="radio" name="type" value="2" required="required">厂商&nbsp;
                <input type="radio" name="type" value="3" required="required">员工
            </div>
            <br>
            <div id="login" style="text-align: center">
                <input type="submit" value="下一步"/>
            </div>
            <br>
            <div id="register">
                <input type="button" value="已有账号？去登录" onclick="location.href='index.jsp'" />
            </div>
        </form>
    </div>

</div>
</body>
</html>