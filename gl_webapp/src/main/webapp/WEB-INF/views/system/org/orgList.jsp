<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${basePath}/css/table-form.css" rel="stylesheet"/>
<link href="${basePath}/css/system/user.css" rel="stylesheet"/>
<link href="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet"/>
<link href="${basePath}/common/font-awesome/css/font-awesome.css" rel="stylesheet"/>

<script src="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.js"></script>
<link rel="stylesheet" href="${basePath}/common/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="${basePath}/common/zTree/js/jquery.ztree.all.js"></script>
<script src="${basePath}/common/layer/layer.js"></script>
<script src="${basePath}/js/system/org/orgList.js"></script>

</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${basePath}/admin/org/list.do">机构列表</a></li>
		<li >
			<a href="${basePath}/admin/org/edit.do?org.id=">
				添加机构
			</a>
		</li>
	</ul>

	<div class="row table-form" >
		<form class="form-horizontal" role="form" id="searchForm">
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">名称</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="name" name="name" placeholder="请输入名字">
			    </div>
			    <div class="col-sm-2">
		      		<button type="button" id="select" class="btn btn-default">查询</button>
		    	</div>
		  	</div>
		</form>
	</div>
	<div class="row">
		<table id="dataTable">

		</table>
	</div>
</body>
</html>