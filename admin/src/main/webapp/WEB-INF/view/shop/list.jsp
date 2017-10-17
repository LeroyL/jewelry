<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/12
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Advanced Tables -->
<div class="panel panel-default">
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover" id="dataTables-example">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>店铺名称</th>
                    <th>店铺图标</th>
                    <th>店铺主人</th>
                    <th>店铺开通时间</th>
                    <th>店铺状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:if test="${shops.content.size > 0}">--%>
                    <%----%>
                <%--</c:if>--%>
                <c:forEach items="${shops.content}" var="shop" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${shop.title}</td>
                        <td><img src="${shop.logo}"></td>
                        <td>${shop.ownerId}</td>
                        <td>${shop.createTime}</td>
                        <td>${shop.status}</td>
                        <td>
                            <a href="${ctx}/shop/findOne?id=${shop.id}&oper=show" class="btn btn-info btn-sm">查看</a>
                            <a href="${ctx}/shop/findOne?id=${shop.id}&oper=edit" class="btn btn-primary btn-sm">编辑</a>
                            <a href="#" class="btn btn-danger btn-sm">删除</a>
                                <%--<a href="#" class="btn btn-success btn-sm">success</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<!--End Advanced Tables -->