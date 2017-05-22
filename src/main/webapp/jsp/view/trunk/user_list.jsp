<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>车主管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../../../main.jsp">主页</a>
                    </li>
                    <li>
                        <strong>车主管理</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <div class="row">
                                <form id="cuser_form" method="post">
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入帐号" name="username" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入姓名" name="certName" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入电话" name="carPhone" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="button" class="btn btn-primary" id="btn_search" value="查找">
                                    </div>
                                </form>
                                <div class="col-sm-2">
                                    <div align="right">
                                        <a class="btn btn-info btn-rounded" href="${ctx}/jsp/view/trunk/add_user.jsp">添加用户</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table  id="cuser_list" class="table table-striped table-bordered table-hover dataTables-example">
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
                            </table>
                            <!-- 分页开始 -->
                            <div class="row">
                                <div class="span12">
                                    <div class="pull-right pagination">
                                        <ul id="pagination"></ul>
                                    </div>
                                </div>
                            </div>
                            <!-- 分页结束 -->
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