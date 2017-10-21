<%--
  User: leroy(lier@gr158.com)
  Date: 2017/10/17
  Time: 15:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺管理-店铺编辑</title>
    <%@include file="../common/header.jsp" %>
    <link href="${ctx}/static/assets/css/fileinput.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/css/shop/shop.css" rel="stylesheet"/>
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
        <h1 class="page-header">店铺编辑</h1>
    </div>
    <div id="page-inner">
        <!-- content -->
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-7">
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-title">店铺名称</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon-title" value="${shop.title}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-owner">店主</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon-owner" value="${owner.name}">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-7">
                <form id="icon-upload-form" enctype="multipart/form-data">
                    <div class="input-group">
                        <span class="input-group-addon input-addon-span" id="basic-addon-icon">店铺图标</span>
                        <input type="button" class="form-control" aria-describedby="basic-addon-icon" value="上传"
                               onclick="upload('icon-upload-form')">
                    </div>
                    <p>
                        <input type="file" name="files" id="fileinput_logo" accept="image/*">
                        <input type="hidden" id="icon-upload-form-input">
                    </p>
                </form>
            </div>
            <div class="col-md-3"></div>
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
                <p class="text-left"><c:choose><c:when
                        test="${owner.sex == 1}">男</c:when><c:otherwise>女</c:otherwise></c:choose></p>
                <p class="text-left">${owner.birthday}</p>
                <p class="text-left">${owner.level}</p>
            </div>
        </div>
        <!-- FOOT -->
        <%@include file="../common/foot.jsp" %>
    </div>
</div>
<%@include file="../common/script.jsp" %>
<script src="${ctx}/static/assets/js/fileinput.js"></script>
<%--<script src="${ctx}/static/assets/js/fileinput.min.js"></script>--%>
<script src="${ctx}/static/assets/js/fileinput_zh.js"></script>
<script src="${ctx}/static/assets/js/jquery.form.min.js"></script>
<script src="${ctx}/static/js/shop/shop.js"></script>
<script src="${ctx}/static/js/shop/upload.js"></script>
<script>
    $(document).ready(function () {
        $("#fileinput_logo").fileinput({
            language: 'zh', //设置语言
            uploadUrl: ctx + "/file/upload", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            showUpload: false, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showPreview: true, //是否显示预览
            showCaption: false,//是否显示标题
            dropZoneEnabled: false,//是否显示拖拽区域
            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data'
        }).on("fileuploaded", function (event, data, previewId, index) {
            if(data.response.code == 0){
                $("#icon-upload-form-input").val(data.response.data);
            } else {
                alert(data.message);
            }
        });
    });
</script>
</body>
</html>
