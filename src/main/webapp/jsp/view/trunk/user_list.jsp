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
						<div class="">
                            <a href="${ctx}/jsp/view/trunk/add_user.jsp" class="btn btn-primary">添加</a>
                        </div>
                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>账号</th>
                                    <th>注册时间</th>
                                    <th>姓名</th>
                                    <th>电话</th>
                                    <th>开户人</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${user}" var="u">
                                <tr class="gradeA">
                                    <td>${u.username}</td>
                                    <td>${u.registerTime }</td>
                                    <td>${u.certName }</td>
                                    <td class="center">${u.carPhone }</td>
                                    <td class="center">${u.adminId }</td>
                                </tr>
                            </c:forEach>
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
                </div>
            </div>
        </div>
        
        
        
        <jsp:include page="/footer.jsp"/>
    </div>
</div>

</body>