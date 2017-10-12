<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/12
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺管理 - 管理中心</title>
    <%@include file="../common/header.jsp"%>
</head>
<body>
<!-- TOP -->
<%@include file="../common/top.jsp" %>
<!-- LEFT MENU -->
<%@include file="../common/menu.jsp" %>
<!-- CENTER CONTENT -->
<div id="page-wrapper">
    <div class="header">
        <!-- content header -->

    </div>
    <div id="page-inner">
        <!-- content -->
        <div id="content"></div>
        <!-- FOOT -->
        <%@include file="../common/foot.jsp" %>
    </div>
</div>
<%@include file="../common/script.jsp"%>
<script>
    $(document).ready(function () {
        $('.menu-shop').addClass('active-menu');
    })
</script>
</body>
</html>
