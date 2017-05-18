<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@include file="/jsp/common/header.jsp"%>
<head>
    <meta charset="UTF-8">
    <title>按时达后台登录</title>
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div >
        <div>
            <h4 class="logo-name">按时达</h4>
        </div>
        <h3>欢迎使用按时达后台管理</h3>

        <form method="post" action="${ctx}/api/web/user/submit">
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </p>
        </form>
        <font color="red"><c:out value="${loginError}"></c:out>
    </div>
</div>


</body>
