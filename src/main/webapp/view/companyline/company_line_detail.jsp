<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/common/header.jsp"/>
<style>
    .text{
        margin-top: 7px;
        font-weight: 400;
        font-size: 22px;
    }
</style>
<body>
<div id="wrapper">
    <jsp:include page="/left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <jsp:include page="/top.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>用户详情</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="company_line_list.jsp">企业与专线管理</a>
                    </li>
                    <li>
                        <strong>用户详情</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="ibox-content">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">

                            <div class="portlet-body form">
                                <!-- BEGIN FORM-->
                                <form id="pipe_order_detail">
                                    <div class="form-horizontal form-view">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">帐号:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="username"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">密码:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="password"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">联系电话:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="phone"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">注册时间:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="registerTime"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">用户名称:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="certName"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">身份证号:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="certNumber"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">身份证地址:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="certAddress"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">公司名称:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="compName"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">公司地址:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="compAddress"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">公司电话:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="compPhone"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">专线城市:</label>
                                            <div class="col-lg-8">
                                                <span class="text" name="zlineCity"></span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <!-- END FORM-->
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
<script src="../../js/companyline/company_line_detail.js"></script>