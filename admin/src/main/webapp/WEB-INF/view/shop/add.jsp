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
    <%@include file="../common/header.jsp" %>
    <link href="${ctx}/static/assets/css/fileinput.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/css/shop/shop.css" rel="stylesheet"/>
    <link href="${ctx}/static/assets/bootstrap-select/bootstrap-select.min.css" rel="stylesheet"/>
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
            <div class="col-md-2"></div>
            <div class="col-md-7">
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-title">店铺名称</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon-title" id="shop-name">
                </div>
                <div class="input-group">
                    <span class="input-group-addon input-addon-span" id="basic-addon-owner">店主</span>
                    <%--<input type="text" class="form-control" aria-describedby="basic-addon-owner">--%>
                    <select class="form-control selectpicker" data-live-search="true" id="shop-owner">
                        <option>张三</option>
                        <option>李四</option>
                        <option>王五</option>
                    </select>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-7">
                <form id="logo-upload-form" enctype="multipart/form-data">
                    <div class="input-group">
                        <span class="input-group-addon input-addon-span">店铺图标</span>
                        <input type="button" class="form-control" value="上传"
                               onclick="upload('logo-upload-form')">
                    </div>
                    <div>
                        <input type="file" name="files" id="fileinput_logo" accept="image/*">
                        <input type="hidden" id="logo-upload-form-input">
                    </div>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>

        <%--<div class="row">--%>
            <%--<div class="row">--%>
                <%--<div class="col-md-2"></div>--%>
                <%--<div class="col-md-7">--%>
                    <%--<form id="advert-upload-form" enctype="multipart/form-data">--%>
                        <%--<div class="input-group">--%>
                            <%--<span class="input-group-addon input-addon-span" id="basic-addon-advert">店铺广告</span>--%>
                            <%--<input type="button" class="form-control" aria-describedby="basic-addon-advert" value="上传"--%>
                                   <%--onclick="upload('advert-upload-form')">--%>
                        <%--</div>--%>
                        <%--<div class="input-group">--%>
                            <%--<input type="file" name="files" id="fileinput_advert" accept="image/*">--%>
                            <%--<input type="hidden" id="advert-upload-form-input">--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>
                <%--<div class="col-md-3"></div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <button type="button" class="btn btn-primary" onclick="saveShop()">保存</button>
                <a class="btn btn-info" href="${ctx}/shop">取消</a>
            </div>
            <div class="col-md-4"></div>
        </div>
        <!-- FOOT -->
        <%@include file="../common/foot.jsp" %>
    </div>
</div>
<%@include file="../common/script.jsp" %>
<script src="${ctx}/static/assets/bootstrap-select/bootstrap-select.min.js"></script>
<script src="${ctx}/static/assets/bootstrap-select/defaults-zh_CN.min.js"></script>

<script src="${ctx}/static/assets/js/fileinput.min.js"></script>
<script src="${ctx}/static/assets/js/fileinput_zh.js"></script>
<script src="${ctx}/static/assets/js/jquery.form.min.js"></script>

<script src="${ctx}/static/js/shop/upload.js"></script>

<script src="${ctx}/static/js/shop/shop.js"></script>
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
            maxFileCount: 1, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data'
        }).on("fileuploaded", function (event, data, previewId, index) {
            if (data.response.code == 0) {
                $("#logo-upload-form-input").val(data.response.data);
            } else {
                alert(data.message);
            }
        });

//        $("#fileinput_advert").fileinput({
//            language: 'zh', //设置语言
//            uploadUrl: ctx + "/file/upload", //上传的地址
//            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
//            showUpload: false, //是否显示上传按钮
//            showRemove: true, //显示移除按钮
//            showPreview: true, //是否显示预览
//            showCaption: false,//是否显示标题
//            dropZoneEnabled: false,//是否显示拖拽区域
//            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
//            maxFileCount: 5, //表示允许同时上传的最大文件个数
//            enctype: 'multipart/form-data'
//        }).on("fileuploaded", function (event, data, previewId, index) {
//            if (data.response.code == 0) {
//                $("#advert-upload-form-input").val(data.response.data);
//            } else {
//                alert(data.message);
//            }
//        });
    });
</script>
</body>
</html>
