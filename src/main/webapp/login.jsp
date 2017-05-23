<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
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

        <form id="user_login_form">
            <div class="form-group">
                <input type="text" class="form-control" name="userName" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="passWord" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b" id="btn_submit_login">登 录</button>
        </form>
    </div>
</div>


</body>
<script src="${ctx}/js/login.js"></script>
