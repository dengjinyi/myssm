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
<script src="${basePath}/js/system/user/userList.js"></script>

</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${basePath}/admin/user/list.do">用户列表</a></li>
		<li ><a href="${basePath}/admin/user/edit.do?id=">用户添加</a></li>
	</ul>
	<div class="row table-form" >
		<form class="form-horizontal" role="form" id="searchForm">
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">登录名</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="account" onkeyup="AutoMatch(this)" placeholder="请输入名字">
			    </div>
		    	<label for="firstname" class="col-sm-1 control-label">名称</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="name" name="name" placeholder="请输入名字">
			    </div>
			    <div id="aaa"></div>
		  	</div>
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">部门</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="orgId" name="orgId" placeholder="请输入名字">
			    </div>
		    	<label for="firstname" class="col-sm-1 control-label">公司</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="company" name="company" placeholder="请输入名字">
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
	
	
	<div id="toolbar" class="btn-group">
	 	<button id="addUser" type="button" class="btn btn-default">
	 		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	 	</button>
	 	<button id="btn_edit" type="button" class="btn btn-default">
	 		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	 	</button>
	 	<button id="deleteUser" type="button" class="btn btn-default">
	 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	 	</button>
 	</div>
 	



<div id="menuContent" class="menuContent" style="display: none; position: absolute;width: 240px;
    background: #fff;
    border: 1px solid #D6D6D6;
    max-height: 200px;
    overflow-y: auto;">
        <ul id="treeDemo" class="ztree" style="margin-top: 0; width: 110px;">
        </ul>
</div>
</body>
</html>