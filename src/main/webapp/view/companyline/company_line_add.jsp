<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/common/header.jsp"/>
<style>
    .col-lg-2 {
        padding-top: 7px;
    }
</style>
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
                        <a href="javascript:" onclick="self.location=document.referrer;">企业与专线管理</a>
                    </li>
                    <li>
                        <strong>添加用户</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="ibox-content">
                <div class="row">
                    <div class="col-sm-6">
                        <form class="form-horizontal" id="comp_line_form" >
                            <div class="form-group">
                                <label class="col-lg-3 control-label">用户类型<span class="required">*</span></label>
                                <div class="col-lg-8">
                                    <select class="form-control" name="userTypeId" id="userTypeId">
                                        <option value="1" selected>企业版</option>
                                        <option value="2">专线版</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">帐号<span class="required">*</span></label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入帐号" class="form-control" name="username" id="user_name_id">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">密码<span class="required">*</span></label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入密码" class="form-control" name="password" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">姓名:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入姓名" class="form-control" name="certName" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">联系电话:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入联系电话，多个以逗号分割" class="form-control" name="phone" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">身份证号:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入身份证号" class="form-control" name="certNumber" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">身份证地址:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入身份证地址" class="form-control" name="certAddress" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">公司名称:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入公司名称" class="form-control" name="compName" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">公司地址:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入公司地址" class="form-control" name="compAddress" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">公司电话:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入公司电话" class="form-control" name="compPhone" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">公司简介:</label>
                                <div class="col-lg-8">
                                    <textarea maxlength="1000" placeholder="公司简介"
                                              class="form-control" cols="" rows="5"
                                              name="compIntroduction"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">专线城市:</label>
                                <div class="col-lg-8">
                                    <input type="text" placeholder="请输入专线城市，多个以#分割" class="form-control" name="zlineCity" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">备注:</label>
                                <div class="col-lg-8">
                                    <textarea maxlength="1000" placeholder="备注"
                                              class="form-control" cols="" rows="5"
                                              name="remark"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">平台类型:</label>
                                <div class="col-lg-2 ">
                                    <input type="checkbox" value="2" name="aloginType" id="aloginType">Android
                                </div>
                                <div class="col-lg-6 ">
                                    <input id="astopTime" placeholder="请输入Android到期时间" name="astopTime" class="laydate-icon form-control layer-date ">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label"></label>
                                <div class="col-lg-2">
                                    <input type="checkbox" value="1" name="iloginType" id="iloginType">iOS
                                </div>
                                <div class="col-lg-6">
                                    <input id="istopTime" placeholder="请输入iOS到期时间" name="istopTime" class="laydate-icon form-control layer-date">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-3 col-lg-8">
                                    <button class="btn btn-primary" id="btn_comp_line" type="submit">添加</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/footer.jsp"/>
    </div>
</div>
</div>
</body>
<script type="text/javascript">
    laydate({elem:"#astopTime",event:"focus"});
    laydate({elem:"#istopTime",event:"focus"});
</script>
<script src="../../js/companyline/company_line_add.js"></script>