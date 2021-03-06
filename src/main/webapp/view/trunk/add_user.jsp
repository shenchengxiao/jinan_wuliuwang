<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<jsp:include page="/common/header.jsp"></jsp:include>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
		<div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>添加用户</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="javascript:" onclick="self.location=document.referrer;">车主管理</a>
                    </li>
                    <li>
                        <strong>添加用户</strong>
                    </li>
                </ol>
            </div>
        </div>
		<!-- content -->
		<div class="wrapper wrapper-content animated fadeInRight">
            <div class="ibox-content">
                <div class="row">
                    <div class="col-sm-6">
                        <form class="form-horizontal" id="add_user_info_form" >

                            <div class="form-group">
                                <label class="col-lg-3 control-label">帐号<span class="required">*</span></label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入帐号" class="form-control" id="username" name="username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">密码<span class="required">*</span></label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入密码" class="form-control" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">姓名：</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入姓名" class="form-control" name="certName" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">联系电话：</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入联系电话" class="form-control" name="carPhone" >
                                </div>
                            </div>
                            <!-- <div class="form-group">
                                <label class="col-lg-3 control-label">到期时间：<span class="required">*</span></label>
                                <div class="col-lg-8">
                                	
                                	
                                </div>
                            </div> -->
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车长：</label>
                                <div class="col-lg-8">
                                	<input type="text" placeholder="请输入车长" class="form-control" name="carLength">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车重：</label>
                                <div class="col-lg-8">
                                	<input type="text" placeholder="请输入车重" class="form-control" name="carWeight">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车牌号1：</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入车牌号1" class="form-control" name="carNumber1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车牌号2：</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入车牌号2" class="form-control" name="carNumber2">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车类型：</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入车类型" class="form-control" name="carType">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车状态：</label>
                                <div class="col-lg-8">
                                	<select class="form-control m-b" name="carStatues">
                                        <option value="0">空车</option>
                                        <option value="1">满载</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label"></label>
                                <div class="col-lg-8">
                                	<input type="checkbox" value="2" name="aloginType" id="aloginType">&nbsp;&nbsp;Android&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input id="astopTime" placeholder="请输入Android到期时间" name="astopTime" class="laydate-icon form-control layer-date">
                                	<!-- <select class="form-control m-b" name="loginType" id="loginType">
                                        <option value="2">Android</option>
                                        <option value="1">IOS</option>
                                    </select> -->
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label"></label>
                                <div class="col-lg-8">
                                    <input type="checkbox" value="1" name="iloginType" id="iloginType">&nbsp;&nbsp;IOS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                	&nbsp;&nbsp;
                                	<input id="istopTime" placeholder="请输入IOS到期时间" name="istopTime" class="laydate-icon form-control layer-date">
                                	<!-- <select class="form-control m-b" name="loginType" id="loginType">
                                        <option value="2">Android</option>
                                        <option value="1">IOS</option>
                                    </select> -->
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-3 col-lg-8">
                                    <button class="btn btn-primary" id="save_from" type="submit">添加</button>
                                    <button class="btn btn-white" type="button" id="cancel">取消</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <!-- content -->
        <jsp:include page="/footer.jsp"/>
    </div>
	</div>
    
    </div>
</div>
    <script type="text/javascript">
    laydate({elem:"#astopTime",event:"focus"});
    laydate({elem:"#istopTime",event:"focus"});
    </script>
<script src="${ctx}/js/trunk/add_user.js"></script>
</body>