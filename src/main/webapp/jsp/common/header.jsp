<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="systemTitle" value="按时达管理平台"/>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiV="pragma" content="no-cache">
<meta http-equiV="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiV="expires" content="0">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<link href="${ctx }/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">

<!-- Morris -->
<link href="${ctx }/static/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

<link href="${ctx}/static/css/xcConfirm.css" rel="stylesheet" type="text/css"/>

<!-- Gritter -->
<link href="${ctx }/static/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

<link href="${ctx }/static/css/animate.css" rel="stylesheet">
<link href="${ctx }/static/css/style.css?v=2.2.0" rel="stylesheet">
<link href="${ctx }/static/js/plugins/layer/skin/layer.css" rel="stylesheet">
<title>${systemTitle}</title>
</head>

<!-- Mainly scripts -->
<script src="${ctx}/static/js/jquery-1.10.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${ctx}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<%--<script src="${ctx}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>--%>

<script src="${ctx}/static/js/toast.js"></script>
<script src="${ctx}/static/js/progressbar.js"></script>

<!-- Flot -->
<script src="${ctx}/static/js/plugins/flot/jquery.flot.js"></script>
<script src="${ctx}/static/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="${ctx}/static/js/plugins/flot/jquery.flot.spline.js"></script>
<script src="${ctx}/static/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="${ctx}/static/js/plugins/flot/jquery.flot.pie.js"></script>

<!-- Peity -->
<script src="${ctx}/static/js/plugins/peity/jquery.peity.min.js"></script>
<script src="${ctx}/static/js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="${ctx}/static/js/hplus.js?v=2.2.0"></script>
<script src="${ctx}/static/js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="${ctx}/static/js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- GITTER -->
<script src="${ctx}/static/js/plugins/gritter/jquery.gritter.min.js"></script>

<!-- Sparkline -->
<script src="${ctx }/static/js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- 表单验证 -->
<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>
<script src="${ctx}/static/js/xcConfirm.js"></script>

<script src="${ctx}/static/js/plugins/layer/laydate/laydate.js"></script>

<script src="${ctx}/static/js/jqPaginator.js"></script>
<script src="${ctx}/js/common.js"></script>


<<style>
.table th, .table td {
text-align: center;
vertical-align: middle!important;
}
</style>

