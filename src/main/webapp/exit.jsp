<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/8/14
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>

<body>
    <%session.invalidate();%>
    <jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>
