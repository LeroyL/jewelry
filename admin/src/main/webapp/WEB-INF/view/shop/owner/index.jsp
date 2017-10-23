<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/19
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺管理 - 管理中心</title>
    <%@include file="../../common/header.jsp"%>
    <%--<link href="${ctx}/static/css/shop/shop.css" rel="stylesheet" />--%>
</head>
<body>
<!-- TOP -->
<%@include file="../../common/top.jsp" %>
<!-- LEFT MENU -->
<%@include file="../../common/menu.jsp" %>
<!-- CENTER CONTENT -->
<div id="page-wrapper">
    <div class="header">
        <!-- content header -->
        <h1 class="page-header">
            店主管理
        </h1>
        <p><a href="${ctx}/shopOwner/add" class="btn btn-primary btn-sm">添加店主</a></p>
    </div>

    <div id="page-inner">
        <!-- content -->
        <div id="content"></div>
        <!-- FOOT -->
        <%@include file="../../common/foot.jsp" %>
    </div>
</div>
<%@include file="../../common/script.jsp"%>
<!-- DATA TABLE SCRIPTS -->
<script src="${ctx}/static/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<script src="${ctx}/static/js/shop/shopOwner.js"></script>
</body>
</html>
