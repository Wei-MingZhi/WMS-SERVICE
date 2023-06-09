<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>WMS仓库后台管理</title>
	<meta name="description" content="WMS仓库后台管理">
	<meta name="keywords" content="WMS仓库后台管理">

	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


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
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

	<!-- 页面头部 -->
	<jsp:include page="header.jsp"/>
	<!-- 页面头部 /-->
	<!-- 导航侧栏 -->
	<jsp:include page="aside.jsp"/>
	<!-- 导航侧栏 /-->

	<!-- 内容区域 -->
	<div class="content-wrapper">
		<!-- 内容头部 -->
		<section class="content-header">
			<h1>
				角色管理 <small>添加资源权限</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="main.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/role/role-list.do">角色管理</a></li>
				<li class="active">添加资源权限</li>
			</ol>
		</section>
		<!-- 内容头部 /-->

		<!-- 正文区域 -->
		<form action="${pageContext.request.contextPath}/role/add-role-permission-list.do" method="post">
			<section class="content">
				<!--数据列表-->
				<input type="hidden" name="roelId" value="${role.id}">
				<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
					<thead>
					<tr>
						<th class="" style="padding-right: 0px;">
							<input id="selall" type="checkbox" class="icheckbox_square-blue">
						</th>
						<th class="sorting_asc" hidden = "hidden">ID</th>
						<th class="sorting_desc">资源权限名称</th>
						<th class="sorting_asc sorting_asc_disabled">资源权限URL</th>
						<th class="sorting_asc">操作</th>
					</tr>
					</thead>
					<tbody>

					<c:forEach items="${permissionList}" var="permission">
						<tr>
							<td><input name="ids" type="checkbox" value="${permission.id}"></td>
							<td hidden = "hidden">${permission.id }</td>
							<td>${permission.permissionName }</td>
							<td>${permission.url }</td>
							<td class="text-center">
								<a href="${pageContext.request.contextPath}/role/add-role-permission.do?permissionId=${permission.id}&roleId=${role.id}" class="btn bg-olive btn-xs">添加此资源权限</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</section>
			<div class="box-tools text-center">
				<a type="button" class="btn bg-default" style="background-color: #949494;color: #ffffff" href="${pageContext.request.contextPath}/role/role-list.do" >返回</a>
			</div>

		</form>
		<!-- 正文区域 /-->
	</div>
	<!-- @@close -->
	<!-- 内容区域 /-->

</div>


<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
	function success(){
		alert("添加权限成功！");
	}

	$(document).ready(function() {
		// 选择框
		$(".select2").select2();

		// WYSIHTML5编辑器
		$(".textarea").wysihtml5({
			locale : 'zh-CN'
		});
	});

	//设置每页显示的条数
	<%--var opts = $('#selectbypage').find('option');--%>
	<%--opts.each(function () {--%>
	<%--	if($(this).val() == ${pageInfo.pageSize}) {--%>
	<%--		$(this).attr('selected', true);--%>
	<%--	}--%>
	<%--});--%>
	<%--$("#selectbypage").click(function () {--%>
	<%--	var selectpage = $("#selectbypage").val();--%>
	<%--	location.href="${pageContext.request.contextPath}/product/findAll.do?page=1&size="+selectpage+"&fuzzyName=${fuzzyName}";--%>
	<%--});--%>
	function selectByPage() {
		//获取下拉框的值
		var pageSize=$("#selectByPage").val();

		//向服务器发送请求，改变没页显示条数
		location.href = "${pageContext.request.contextPath}/product/findAll.do?page=1&size="
				+ pageSize;
	}


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
		setSidebarActive("system-setting-2");

		// 列表按钮
		$("#dataList td input[type='checkbox']").iCheck({
			checkboxClass : 'icheckbox_square-blue',
			increaseArea : '20%'
		});
		// 全选操作
		$("#selall").click(function() {
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