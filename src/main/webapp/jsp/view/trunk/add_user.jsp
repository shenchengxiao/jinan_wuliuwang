<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
		
		<!-- content -->
		<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" id="add_user_info_form">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">账号：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="username" name="username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">密码：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="certName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">电话：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carPhone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">登录类型</label>

                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="loginType">
                                        <option value="1">Android</option>
                                        <option value="2">IOS</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">到期时间：</label>
                                <div class="col-sm-10">
                                    <input id="stopTime" name="stopTime" class="laydate-icon form-control layer-date">
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车长：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carLength">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车重：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carWeight">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车牌号1：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carNumber1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车牌号2：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carNumber2">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车类型：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="carType">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">车状态</label>

                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="carStatues">
                                        <option value="0">空车</option>
                                        <option value="1">满载</option>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit" id="save_from">保存内容</button>
                                    <button class="btn btn-white" type="button" id="cancel">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		<!-- content -->
	</div>
    <jsp:include page="/footer.jsp"/>
    </div>
</div>
    <script type="text/javascript">
    laydate({elem:"#stopTime",event:"focus"});
        //laydate({elem:"#hello",event:"focus"});var start={elem:"#start",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(datas){end.min=datas;end.start=datas}};var end={elem:"#end",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(datas){start.max=datas}};laydate(start);laydate(end);
    </script>
<script src="${ctx}/js/trunk/add_user.js"></script>
</body>