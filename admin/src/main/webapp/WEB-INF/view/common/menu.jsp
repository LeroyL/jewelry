<%--
  User: leroy(lier@gr158.com)
  Date: 2017/10/12
  Time: 14:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <a href="${ctx}/shop" class="active-menu"><i class="fa fa-menu-shop"></i>店铺管理</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-menu-product"></i>产品管理</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/productType">类目管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/product">产品管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="${ctx}/good"><i class="fa fa-menu-good"></i>商品管理</a>
            </li>
            <li>
                <a href="${ctx}/order"><i class="fa fa-menu-order"></i>订单管理</a>
            </li>
            <li>
                <a href="${ctx}/user"><i class="fa fa-menu-user"></i>用户管理</a>
            </li>
            <li>
                <a href="${ctx}/bill"><i class="fa fa-menu-bill"></i>账单管理</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-menu-system"></i>系统管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">人员管理</a>
                    </li>
                    <li>
                        <a href="#">权限管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/commission">佣金管理</a>
                    </li>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Link<span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-third-level">--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->