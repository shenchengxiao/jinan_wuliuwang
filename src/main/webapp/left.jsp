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
                <a href="#"><i class="fa fa-columns"></i> <span class="nav-label">用户管理 </span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${ctx}/view/trunk/user_list.jsp">车主管理</a>
                    </li>
                    <li><a href="${ctx}/view/companyline/company_line_list.jsp">企业与专线管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-columns"></i> <span class="nav-label">系统管理 </span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${ctx}/view/admin/admin_list.jsp">帐号列表</a>
                    </li>
                </ul>
            </li>
        </ul>

    </div>
</nav>
