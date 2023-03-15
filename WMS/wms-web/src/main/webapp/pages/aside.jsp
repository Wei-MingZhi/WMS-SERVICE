<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index">
				<a href="${pageContext.request.contextPath}/pages/main.jsp">
					<i class="fa fa-bar-chart"></i>
					<span>首页</span>
				</a>
			</li>
			<%-- 库区库位及物品管理权限设置 --%>
			<security:authorize access="hasAnyRole('KING','ADMIN')">
				<li id="storage-location">
					<a href="${pageContext.request.contextPath}/storageLocation/storage-location-list.do">
						<i class="fa fa-align-justify"></i>
						<span>库区库位管理</span>
					</a>
				</li>
				<li id="material">
					<a href="${pageContext.request.contextPath}/material/select-material-all.do">
						<i class="fa fa-cube"></i>
						<span>物品管理</span>
					</a>
				</li>
			</security:authorize>
			<li id="Outbound-apply">
				<a href="${pageContext.request.contextPath}/out-put-warehouse/material-list.do">
					<i class="fa fa-hdd-o"></i>
					<span>物品出入库申请</span>
				</a>
			</li>
			<li id="Outbound-apply-record">
				<a href="${pageContext.request.contextPath}/out-put-warehouse/select-warehouse-record.do">
					<i class="fa fa-copy" ></i>
					<span>物品出入库申请记录</span>
				</a>
			</li>
			<security:authorize access="hasAnyRole('KING','ADMIN','WAREHOUSE')">
			<li id="storage-location-revolving">
				<a href="${pageContext.request.contextPath}/storage-location-revolving/select-material.do">
					<i class="fa fa-refresh"></i>
					<span>物品库位周转申请</span>
				</a>
			</li>
			<li id="storage-location-revolving-record">
				<a href="${pageContext.request.contextPath}/storage-location-revolving/select-revolving-record.do">
					<i class="fa fa-list-alt"></i>
					<span>物品库位周转申请记录</span>
				</a>
			</li>
			</security:authorize>
			<%-- 设置菜单页面权限 系统管理 KING 和 ADMIN 角色才能访问 --%>
			<security:authorize access="hasAnyRole('KING','ADMIN')">
				<li class="treeview">
					<a href="#">
						<i class="fa fa-cogs"></i>
						<span>系统管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li id="system-setting-1">
							<a href="${pageContext.request.contextPath}/users/users-list.do">
								<i class="fa fa-circle-o"></i> 人员管理
							</a>
						</li>
						<li id="system-setting-2"><a
							href="${pageContext.request.contextPath}/role/role-list.do">
							<i class="fa fa-circle-o"></i> 角色管理
							</a>
						</li>
						<li id="system-setting-3">
							<a href="${pageContext.request.contextPath}/permission/permission-list.do">
								<i class="fa fa-circle-o"></i> 资源权限管理
							</a>
						</li>
	<%--					<li id="system-setting-4">--%>
	<%--						<a href="${pageContext.request.contextPath}/sysLog/findAll.do">--%>
	<%--							<i class="fa fa-circle-o"></i> 访问日志--%>
	<%--						</a>--%>
	<%--					</li>--%>
					</ul>
				</security:authorize>
			</li>

</ul>
</section>
<!-- /.sidebar -->
</aside>