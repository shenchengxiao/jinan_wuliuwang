<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@include file="/jsp/common/header.jsp"%>
<html>
	<head>
	</head>
	<body>
	<div style="margin-top:50px;">
		<center><font color="red" size="2px">对不起,请从新登陆,系统在一秒后自动跳转!</font></center>
	</div>
<script language="javascript">
	function newLocation(){
		window.parent.location="${ctx}/";
	}
	window.setTimeout(newLocation,1000);
</script>
	</body>
</html>
