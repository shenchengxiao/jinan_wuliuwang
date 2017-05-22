<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">

        </div>
        <ul class="nav navbar-top-links navbar-right">

            <li>
                <span class="m-r-sm text-muted welcome-message" id="login_user_name">super</span>
            </li>
            <li>
                <span class="m-r-sm text-muted welcome-message"><a href="${ctx}/main.jsp" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用</span>
            </li>
            <li>
                <a href="javascript:;" id="logout">
                    <i class="fa fa-sign-out"></i> 退出
                </a>
            </li>
        </ul>
    </nav>
</div>

