<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>车主管理</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_data_tables.html#">选项1</a>
                                </li>
                                <li><a href="table_data_tables.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form role="form" class="form-inline" id="cuser_form">
                        	<input type="hidden" name="pageNum" id="pageNum" value="1">
                            <div class="form-group">
                                <label class="sr-only">账号</label>
                                <input type="text" placeholder="请输入账号" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">姓名</label>
                                <input type="text" placeholder="请输入姓名" name="certName" id="certName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">电话</label>
                                <input type="text" placeholder="请输入电话" name="carPhone" id="carPhone" class="form-control">
                            </div>&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="btn btn-primary" type="button" id="btn_search">查询</button>
                        </form>
                    </div>
                    <div class="ibox-content">
						<div class="">
                            <a href="${ctx}/jsp/view/trunk/add_user.jsp" class="btn btn-primary">添加</a>
                        </div>
                        <table id="cuser_list" class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>账号</th>
                                    <th>注册时间</th>
                                    <th>姓名</th>
                                    <th>电话</th>
                                    <th>开户人</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                           <!--  <tfoot>
                                <tr>
                                    <th>渲染引擎</th>
                                    <th>浏览器</th>
                                    <th>平台</th>
                                    <th>引擎版本</th>
                                    <th>CSS等级</th>
                                </tr>
                            </tfoot> -->
                        </table>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="pull-right pagination">
                                <ul id="pagination"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/footer.jsp"/>
    </div>
</div>
<script src="${ctx}/js/trunk/user_list.js"></script>
</body>