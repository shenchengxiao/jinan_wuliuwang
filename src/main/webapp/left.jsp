<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">

                <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="${ctx}/static/img/profile_small.jpg"/>
                             </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear"> <span class="block m-t-xs"> <strong
                                        class="font-bold">${sessionScope.loginName}</strong>
                             </span>  <span class="text-muted text-xs block">${sessionScope.realName }<b
                                        class="caret"></b></span> </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="#">个人资料</a></li>
                        <li><a href="#">联系我们</a></li>
                        <li class="divider"></li>
                        <li><a href="logout.jsp">安全退出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    H+
                </div>

            </li>

            <%--<li>--%>
                <%--<a href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">口粮商家账号 </span><span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li><a href="${ctx}/api/web/user/message">账号中心</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="${ctx}/api/web/batch/recharge">批充详情</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="${ctx}/api/web/flowcard/list">流量卡详情</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="${ctx}/api/web/integral/list">下发积分</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <li>
                <a href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">活动 </span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${ctx}/api/web/activity/list">活动管理</a>
                    </li>
                    <li><a href="${ctx}/api/web/activity/recommend">活动推荐管理</a>
                    </li>
                    <li><a href="${ctx}/api/web/tag/manage">活动标签管理</a>
                    </li>
                    <%--<li><a href="#">微信活动</a>--%>
                    <%--</li>--%>
                </ul>
            </li>
            <%--<li>--%>
                <%--<a href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">banner管理 </span><span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li><a href="${ctx}/api/web/banner/list?adType=0">首页banner</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="${ctx}/api/web/banner/list?adType=1">签到banner</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

        </ul>

    </div>
</nav>
