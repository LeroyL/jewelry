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
                <a href="${ctx}/index" class="menu-index"><i class="fa fa-menu-shop"></i>首页</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-menu-shop"></i>店铺管理</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/shop" class="menu-shop">店铺管理</a>
                    </li>
                    <li>
                        <a href="#" class="menu-shop-owner">店主管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-menu-product"></i>产品管理</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/productType" class="menu-productType">类目管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/product" class="menu-product">产品管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="${ctx}/good" class="menu-good"><i class="fa fa-menu-good"></i>商品管理</a>
            </li>
            <li>
                <a href="${ctx}/order" class="menu-order"><i class="fa fa-menu-order"></i>订单管理</a>
            </li>
            <li>
                <a href="${ctx}/user" class="menu-user"><i class="fa fa-menu-user"></i>用户管理</a>
            </li>
            <li>
                <a href="${ctx}/bill" class="menu-bill"><i class="fa fa-menu-bill"></i>账单管理</a>
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
                </ul>
            </li>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->