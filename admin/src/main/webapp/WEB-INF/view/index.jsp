<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/9
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页 - 管理中心</title>
    <%@include file="common/header.jsp" %>
</head>
<body>
<!-- TOP -->
<%@include file="common/top.jsp" %>
<!-- LEFT MENU -->
<%@include file="common/menu.jsp" %>
<!-- CENTER CONTENT -->
<div id="page-wrapper">
    <div class="header">
        <!-- content header -->
        <h1 class="page-header">
            管理中心
            <small>Welcome!</small>
        </h1>
    </div>
    <div id="page-inner">
        <!-- content -->
        <div class="row">
            <div class="col-md-3 col-sm-12 col-xs-12">
                <div class="panel panel-primary text-center no-boder blue">
                    <div class="panel-left pull-left blue">
                        <i class="fa fa-eye fa-5x"></i>
                    </div>
                    <div class="panel-right">
                        <h3>10,253</h3>
                        <strong> Daily Visits</strong>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <div class="panel panel-primary text-center no-boder blue">
                    <div class="panel-left pull-left blue">
                        <i class="fa fa-shopping-cart fa-5x"></i>
                    </div>
                    <div class="panel-right">
                        <h3>33,180 </h3>
                        <strong> Sales</strong>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <div class="panel panel-primary text-center no-boder blue">
                    <div class="panel-left pull-left blue">
                        <i class="fa fa fa-comments fa-5x"></i>
                    </div>
                    <div class="panel-right">
                        <h3>16,022 </h3>
                        <strong> Comments </strong>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <div class="panel panel-primary text-center no-boder blue">
                    <div class="panel-left pull-left blue">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="panel-right">
                        <h3>36,752 </h3>
                        <strong>No. of Visits</strong>
                    </div>
                </div>
            </div>
        </div>
        <!-- FOOT -->
        <%@include file="common/foot.jsp" %>
    </div>
</div>
<%@include file="common/script.jsp" %>
</body>
</html>
