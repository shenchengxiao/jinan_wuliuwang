<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/common/header.jsp"/>
<%--模态框样式设置--%>
<style>
    .modal.fade.in {
        top: 20%;
    }

</style>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>帐号管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../../main.jsp">主页</a>
                    </li>
                    <li>
                        <strong>帐号管理</strong>
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
                                <form id="admin_list_form" method="post">
                                    <input type="hidden" name="pageNum" id="pageNum" value="1">
                                </form>
                                <div class="col-sm-12 actions">
                                    <div align="right">
                                        <a class="btn btn-info btn-rounded" id="add_admin_id">添加帐号</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table id="admin_list" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>帐号</th>
                                    <th>是否启用</th>
                                    <th>创建时间</th>
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
    <!-- modal 添加 begin -->

    <div class="modal fade in" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                    <h4 class="modal-title" id="myModalLabel">开通帐号</h4>
                </div>
                <form action="#" class="form-horizontal" id="add_admin_form">
                    <div class="modal-body">
                        <input type="hidden" name="id">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">帐号<span class="required">*</span></label>
                            <div class="col-lg-8">
                                <input type="text" placeholder="请输入帐号" class="form-control" name="userName" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">密码<span class="required">*</span></label>
                            <div class="col-lg-8">
                                <input type="text" placeholder="请输入密码" class="form-control" name="passWord" >
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary green" id="btn_add_admin">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- modal 添加 end -->
</div>
</div>
</body>
<script src="../../js/admin/admin_list.js"></script>
