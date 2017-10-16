<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/9
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 - 管理中心</title>
    <%@include file="common/header.jsp"%>
    <link href="${ctx}/static/css/login.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper login-panel" class="login-panel">
    <form role="form">
        <div class="form-group">
            <input class="form-control" placeholder="请输入用户名" id="account">
        </div>
        <div class="form-group">
            <input class="form-control" placeholder="请输入密码" type="password" id="password">
        </div>
        <div class="form-group  has-error login-message">
            <label class="control-label"></label>
        </div>
        <div class="form-group login-btn">
            <a href="#" class="btn btn-primary btn-lg" id="login-btn">登录</a>
        </div>
    </form>
    <input type="hidden" value="${code}" id="code">
</div>
<script>
    var ctx = '${ctx}';
</script>
<script src="${ctx}/static/assets/js/jquery-1.10.2.js"></script>
<script src="${ctx}/static/js/login-helper.js"></script>
<script src="${ctx}/static/js/login.js"></script>
</body>
</html>
