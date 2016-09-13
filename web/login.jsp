
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/servlet/Loginservlet" method="post">
        <div>用户名：<input type="text" name="username"></div>
        <div>密码：<input type="password" name="password"></div>
        <div><input type="submit" value="提交"></div>
    </form>


</body>
</html>
