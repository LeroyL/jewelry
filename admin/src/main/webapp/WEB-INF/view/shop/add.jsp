<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/19
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺管理-店铺查看</title>
    <%@include file="../common/header.jsp"%>
    <link href="${ctx}/static/css/shop/shop.css" rel="stylesheet" />
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
        <h1 class="page-header">店铺查看</h1>
    </div>
    <div id="page-inner">
        <!-- content -->
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-title">店铺名称</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon-title">
                </div>
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-owner">店主</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon-owner">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">选择<span class="caret"></span></button>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <p class="text-right">店铺LOGO</p>
        <div class="row">
            <div class="row">
                <div class="col-md-3">
                    <p class="text-right">店铺广告</p>
                </div>
                <div class="col-md-9">

                </div>
            </div>
        </div>
        <!-- FOOT -->
        <%@include file="../common/foot.jsp" %>
    </div>
</div>
<%@include file="../common/script.jsp"%>
</body>
</html>
