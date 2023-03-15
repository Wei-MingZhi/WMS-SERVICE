<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>WMS仓库后台管理</title>
<meta name="description" content="WMS仓库后台管理">
<meta name="keywords" content="WMS仓库后台管理">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

	<!-- 页面头部 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 页面头部 /-->

	<!-- 导航侧栏 -->
	<jsp:include page="aside.jsp"></jsp:include>
	<!-- 导航侧栏 /-->

	<!-- 内容区域 -->
	<div class="content-wrapper">

		<!-- 内容头部 -->
		<section class="content-header">
		<h1>
			人员管理 <small>全部人员</small>
		</h1>
		<ol class="breadcrumb">
			<li>
				<a href="${pageContext.request.contextPath}/index.jsp">
					<i class="fa fa-dashboard"></i> 首页
				</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/users/users-list.do">人员管理</a></li>

			<li class="active">全部人员</li>
		</ol>
		</section>
		<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!-- .box-body -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">列表</h3>
				</div>

				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--工具栏-->
						<div class="pull-left">
							<div class="form-group form-inline">
								<div class="btn-group">
									<button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/user-add.jsp'">
										<i class="fa fa-file-o"></i> 新建
									</button>

									<button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload()">
										<i class="fa fa-refresh"></i> 刷新
									</button>
								</div>
							</div>
						</div>
						<div class="box-tools pull-right">
							<div class="has-feedback">
								<form action="${pageContext.request.contextPath}/users/users-list.do" method="post">
								<input type="text" class="form-control input-sm" placeholder="请输入人员姓名"  name="userName" value="${userName}">
									<span class="bg-maroon glyphicon glyphicon-search form-control-feedback"/>
								</form>
							</div>
						</div>
						<!--工具栏/-->

						<!--数据列表-->
						<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
							<thead>
								<tr>
									<th class="" style="padding-right: 0px">
										<input id="selall" type="checkbox" class="icheckbox_square-blue">
									</th>
									<th class="sorting_asc" hidden="hidden">ID</th>
									<th class="sorting_desc">人员编号</th>
									<th class="sorting_asc sorting_asc_disabled">人员姓名</th>
									<th class="sorting_desc sorting_desc_disabled">联系电话</th>
									<th class="sorting_desc sorting_desc_disabled">邮箱</th>
									<th class="sorting_desc ">备注</th>
									<th class="sorting_desc ">创建人</th>
									<th class="sorting_desc ">创建时间</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${usersList.list}" var="users">
									<tr>
										<td><input value="${users.id}" name="ids" type="checkbox"></td>
										<td hidden="hidden">${users.id }</td>
										<td>${users.userName }</td>
										<td>${users.userNumber }</td>
										<td>${users.iphone }</td>
										<td>${users.email }</td>
										<td>${users.remark }</td>
										<td>${users.createdBy }</td>
										<td>${users.createdTimeStr }</td>
										<td class="text-center">
											<c:if test="${users.userName != 'admin'}">
											<a href="${pageContext.request.contextPath}/users/users-by-id.do?id=${users.id}" class="btn btn-primary">详情</a>
											<a href="${pageContext.request.contextPath}/users/del-user.do?id=${users.id}" class="btn btn-danger">删除</a>
											<a href="${pageContext.request.contextPath}/users/select-user-role.do?id=${users.id}" class="btn btn-info">添加角色</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!--数据列表/-->

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<div class="box-footer">
					<div class="pull-left">
						<div class="form-group form-inline">
							总共${usersList.pages} 页，共${usersList.total}条数据。 每页
							<select class="form-control" id="fenYe" onchange="fenYe()">
								<option hidden="hidden">${usersList.pageSize}</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select> 条
						</div>
					</div>

					<div class="box-tools pull-right">
						<ul class="pagination">
							<li><a href="${pageContext.request.contextPath}/users/users-list.do?page=1&size=${usersList.pageSize}&userName=${userName}" aria-label="Previous">首页</a></li>
							<li><a href="${pageContext.request.contextPath}/users/users-list.do?page=${usersList.pageNum-1}&size=${usersList.pageSize}&userName=${userName}">上一页</a></li>
							<c:forEach begin="1" end="${usersList.pages}" var="pageNum">
							<li><a href="${pageContext.request.contextPath}/users/users-list.do?page=${pageNum}&size=${usersList.pageSize}&userName=${userName}">${pageNum}</a></li>
							</c:forEach>
							<li><a href="${pageContext.request.contextPath}/users/users-list.do?page=${usersList.pageNum+1}&size=${usersList.pageSize}&userName=${userName}">下一页</a></li>
							<li><a href="${pageContext.request.contextPath}/users/users-list.do?page=${usersList.pages}&size=${usersList.pageSize}&userName=${userName}" aria-label="Next">尾页</a></li>
						</ul>
					</div>

				</div>
			</div>
			</section>
			<!-- 正文区域 /-->
		</div>
	</div>

	<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="../plugins/raphael/raphael-min.js"></script>
	<script src="../plugins/morris/morris.min.js"></script>
	<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="../plugins/knob/jquery.knob.js"></script>
	<script src="../plugins/daterangepicker/moment.min.js"></script>
	<script src="../plugins/daterangepicker/daterangepicker.js"></script>
	<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="../plugins/fastclick/fastclick.js"></script>
	<script src="../plugins/iCheck/icheck.min.js"></script>
	<script src="../plugins/adminLTE/js/app.min.js"></script>
	<script src="../plugins/treeTable/jquery.treetable.js"></script>
	<script src="../plugins/select2/select2.full.min.js"></script>
	<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
	<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script src="../plugins/ckeditor/ckeditor.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="../plugins/chartjs/Chart.min.js"></script>
	<script src="../plugins/flot/jquery.flot.min.js"></script>
	<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
	<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
	<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
	<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script>

	//分条数显示
	function fenYe(){
		var pageSize = $("#fenYe").val();
		location.href="${pageContext.request.contextPath}/users/users-list.do?page=1&size=" + pageSize;
	}

	$(document).ready(function() {
		// 选择框
		$(".select2").select2();

		// WYSIHTML5编辑器
		$(".textarea").wysihtml5({
			locale : 'zh-CN'
		});
	});

	// 设置激活菜单
	function setSidebarActive(tagUri) {
		var liObj = $("#" + tagUri);
		if (liObj.length > 0) {
			liObj.parent().parent().addClass("active");
			liObj.addClass("active");
		}
	}

	$(document).ready(function() {

		// 激活导航位置
		setSidebarActive("admin-datalist");
		setSidebarActive("system-setting-1");

		// 列表按钮
		$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
		// 全选操作
		$("#selall") .click(function() {
			var clicks = $(this).is(':checked');
			if (!clicks) {
				$("#dataList td input[type='checkbox']").iCheck("uncheck");
			} else {
				$("#dataList td input[type='checkbox']").iCheck("check");
			}
			$(this).data("clicks", !clicks);
		});
	});
</script>
</body>

</html>