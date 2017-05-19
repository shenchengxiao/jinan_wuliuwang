<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element" >
                    <span><img alt="image" class="img-circle" src="${ctx}/static/img/profile_small.jpg"/></span>
                </div>
            </li>
            <li>
                <a href="#"><i class="fa fa-columns"></i> <span class="nav-label">活动 </span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${ctx}/api/web/activity/list">活动管理</a>
                    </li>
                    <li><a href="${ctx}/api/web/activity/recommend">活动推荐管理</a>
                    </li>
                    <li><a href="${ctx}/api/web/tag/manage">活动标签管理</a>
                    </li>
                </ul>
            </li>
        </ul>

    </div>
</nav>
