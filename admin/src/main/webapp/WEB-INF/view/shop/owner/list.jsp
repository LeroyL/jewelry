<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leroy
  Date: 2017/10/19
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-striped table-hover" id="dataTables-example">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>店主姓名</th>
                    <th>联系电话</th>
                    <th>店主性别</th>
                    <th>店主生日</th>
                    <th>创建时间</th>
                    <th>推荐人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:if test="${shops.content.size > 0}">--%>
                <%----%>
                <%--</c:if>--%>
                <c:forEach items="${showOwners.content}" var="shopOwner" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${shopOwner.name}</td>
                        <td>${shopOwner.phone}</td>
                        <td>${shopOwner.sex}</td>
                        <td>${shopOwner.birthday}</td>
                        <td>${shopOwner.createTime}</td>
                        <td><c:choose><c:when test="${agent != null}">${agent.name}</c:when><c:otherwise>——</c:otherwise></c:choose></td>
                        <td>
                            <a href="${ctx}/shopOwner/findOne?id=${shopOwner.id}&oper=show" class="btn btn-info btn-sm">查看</a>
                            <a href="${ctx}/shopOwner/findOne?id=${shopOwner.id}&oper=edit" class="btn btn-primary btn-sm">编辑</a>
                            <button type="button" class="btn btn-danger btn-sm" onclick="deleteShop(${shopOwner.id})">删除</button>
                                <%--<a href="#" class="btn btn-success btn-sm">success</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
