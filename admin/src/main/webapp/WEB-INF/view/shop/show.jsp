<%--
  User: leroy(lier@gr158.com)
  Date: 2017/10/17
  Time: 15:47
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
        <div class="page-header">店铺查看</div>
    </div>
    <div id="page-inner">
        <!-- content -->
        <div class="row">
            <div class="col-md-3">
                <p class="text-right">店铺名称</p>
                <p class="text-right">店铺开通时间</p>
                <p class="text-right">店铺状态</p>
                <p class="text-right">店铺LOGO</p>
            </div>
            <div class="col-md-9">
                <p class="text-left">${shop.title}</p>
                <p class="text-left">${shop.createTime}</p>
                <p class="text-left">${shop.status}</p>
                <p class="text-left">
                    <img src="${shop.logo}" class="img-rounded" style="max-height: 100px">
                </p>
            </div>
        </div>
        <div class="row">
            <div class="row">
                <div class="col-md-3">
                    <p class="text-right">店铺广告</p>
                </div>
                <div class="col-md-9">
                    <c:forEach items="${adverts}" var="advert">
                        <div class="col-md-3" style="overflow:hidden;text-overflow: ellipsis;white-space: nowrap;">
                            <img src="${advert.image}" class="img-rounded" style="max-height: 150px">
                            <p><a>${advert.link}</a></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <p class="text-right">店主姓名</p>
                <p class="text-right">联系电话</p>
                <p class="text-right">性别</p>
                <p class="text-right">生日</p>
                <p class="text-right">返利级别</p>
            </div>
            <div class="col-md-9">
                <p class="text-left">${owner.name}</p>
                <p class="text-left">${owner.phone}</p>
                <p class="text-left"><c:choose><c:when test="${owner.sex == 1}">男</c:when><c:otherwise>女</c:otherwise></c:choose></p>
                <p class="text-left">${owner.birthday}</p>
                <p class="text-left">${owner.level}</p>
            </div>
        </div>
        <!-- FOOT -->
        <%@include file="../common/foot.jsp" %>
    </div>
</div>
<%@include file="../common/script.jsp"%>
</body>
</html>

