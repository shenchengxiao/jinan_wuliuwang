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
                <h2>查看用户</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="javascript:" onclick="self.location=document.referrer;">车主管理</a>
                    </li>
                    <li>
                        <strong>查看用户</strong>
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
                                <label class="col-lg-3 control-label">帐号：<span class="required">*</span></label>
                                <div class="col-lg-8">
                                	<span id="username" name="username"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">密码：<span class="required">*</span></label>
                                <div class="col-lg-8">
                                	<span id="password" name="password"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">姓名：</label>
                                <div class="col-lg-8">
                                	<span id="certName" name="certName"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">联系电话：</label>
                                <div class="col-lg-8">
                                	<span id="carPhone" name="carPhone"></span>
                                </div>
                            </div>
                            <!-- <div class="form-group">
                                <label class="col-lg-3 control-label">登录类型：</label>
                                <div class="col-lg-8">
                                	<span id="loginType" name="loginType"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">到期时间：<span class="required">*</span></label>
                                <div class="col-lg-8">
                                	<span id="stopTime" name="stopTime"></span>
                                </div>
                            </div> -->
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车长：</label>
                                <div class="col-lg-8">
                                	<span id="carLength" name="carLength"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车重：</label>
                                <div class="col-lg-8">
                                	<span id="carWeight" name="carWeight"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车牌号1：</label>
                                <div class="col-lg-8">
                                	<span id="carNumber1" name="carNumber1"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车牌号2：</label>
                                <div class="col-lg-8">
                                	<span id="carNumber2" name="carNumber2"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车类型：</label>
                                <div class="col-lg-8">
                                	<span id="carType" name="carType"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">车状态：</label>
                                <div class="col-lg-8">
                                	<span id="carStatues" name="carStatues"></span>
                                	<!-- <select class="form-control m-b" name="carStatues" id="carStatues">
                                        <option value="0">空车</option>
                                        <option value="1">满载</option>
                                    </select> -->
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-3 col-lg-8">
                                    <!-- <button class="btn btn-primary" id="save_from" type="submit">添加</button> -->
                                    <button class="btn btn-white" type="button" id="cancel">返回</button>
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
    laydate({elem:"#stopTime",event:"focus"});
    </script>
<script src="${ctx}/js/trunk/user_detal.js"></script>
</body>