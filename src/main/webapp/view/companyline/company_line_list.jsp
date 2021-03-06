<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/common/header.jsp"/>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>企业与专线管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../../main.jsp">主页</a>
                    </li>
                    <li>
                        <strong>企业与专线管理</strong>
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
                                <form id="user_list_form" method="post">
                                    <div class="col-sm-2">
                                        <div align="left">
                                            <select name="userType" class="form-control">
                                                <option value="" selected>
                                                    全部
                                                </option>
                                                <option value="1">
                                                    企业版
                                                </option>
                                                <option value="2">
                                                    专线版
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入用户帐号" name="accountName" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入用户姓名" name="userName" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" placeholder="请输入联系电话" name="phoneNumber" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                        <button type="button" class="btn btn-primary" id="btn_search">查找</button>
                                    </div>
                                    <input type="hidden" name="pageNum" id="pageNum" value="1">
                                </form>
                                <div class="col-sm-2">
                                    <div align="right">
                                        <a class="btn btn-info btn-rounded" href="company_line_add.jsp">添加用户</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table id="company_line_list" class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>帐号</th>
                                    <th>注册时间</th>
                                    <th>用户姓名</th>
                                    <th>联系电话</th>
                                    <th>用户类型</th>
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

                <div class="modal fade" id="unbind_id" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    解绑
                                </h4>
                            </div>
                            <div class="modal-body">
                                <table  id="user_limit_unbind_list" class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>登录类型</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="modify_date" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel_date">
                                    修改到期时间
                                </h4>
                            </div>
                            <div class="modal-body">
                                <table  id="modify_date_list" class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>登录类型</th>
                                        <th>到期时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/footer.jsp"/>
    </div>
</div>
</div>
</body>
<script src="../../js/companyline/company_line_list.js"></script>
