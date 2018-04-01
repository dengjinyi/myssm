<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增用户</title>
	<link href="${basePath}/css/table-form.css" rel="stylesheet"/>
	<link href="${basePath}/css/system/user.css" rel="stylesheet"/>
	<link href="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet"/>
	<link href="${basePath}/common/font-awesome/css/font-awesome.css" rel="stylesheet"/>
	<script src="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.js"></script>
	<link rel="stylesheet" href="${basePath}/common/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script src="${basePath}/common/zTree/js/jquery.ztree.all.js"></script>
	<script src="${basePath}/common/layer/layer.js"></script>
	<script src="${basePath}/js/system/menu/editMenu.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${basePath}/menu/list.do">菜单列表</a></li>
		<li class="active"><a href="${basePath}/menu/edit.do?id=">
			<c:choose>
				<c:when test="${menu.id !=null}">
					修改菜单
				</c:when>
				<c:otherwise>
					添加菜单
				</c:otherwise>
			</c:choose>
		</a></li>
	</ul>

	<form id="editForm" class="form-horizontal" action="save.do" method="post" novalidate="novalidate" style="margin-top:20px;">
		<input id="id" name="id" type="hidden" value="${menu.id}">
		<div class="form-group">
			<label class="col-sm-2 form-div control-label">上级菜单:</label>
			<div class="col-sm-10 form-div">
				<div class="input-group">
				  <input id="officeName" name="orgName" type="text" value="" readonly="readonly"
					data-msg-required="" class="form-control-input form-input-w250 required">
					<input type="hidden" name="orgId" id="orgId" value="${user.orgId}"/>
				  <div class="input-group-btn" style="float:left">
				    <a id="orgButton" href="javascript:" class="btn form-btn"><i class="glyphicon glyphicon-search" aria-hidden="true" onclick="showCompany()"></i></a>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">菜单名称:</label>
			<div class="col-sm-10">
				<input id="name" name="name" class="form-control-input required" type="text" value="${user.name}" maxlength="50"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">URL:</label>
			<div class="col-sm-10">
				<input id="jobNo" name="jobNo" class="form-control-input required" type="text" value="${user.jobNo}" maxlength="50">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">排序号:</label>
			<div class="col-sm-10">
				<input id="account" name="account" class="form-control-input required" type="text" value="${user.account}" maxlength="50">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">是否可见:</label>
			<div class="col-sm-10">
				<input id="mobile" name="mobile" type="text" class="form-control-input" value="${user.mobile}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">图标:</label>
			<div class="col-sm-10">
				<input id="mobile" name="mobile" type="file" class="form-control-input" value="${user.mobile}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">备注:</label>
			<div class="col-sm-6">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge form-control form-input-w250" rows="3">${user.remark }</textarea>
			</div>
		</div>
		
		<div class="row" style="margin-top:40px;">
			<div class="col-sm-6" style="text-align:center;">
				<button type="button" class="btn btn-primary" id="saveUserBtn">
					保存
				</button>
				<button type="button" id="closeEditBtn" class="btn btn-default" data-dismiss="modal">返回
				</button>
			</div>
		</div>
	</form>
	
	
	
	<div id="menuTreeDiv" style="display: none; position: absolute;width: 180px;
	    background: #fff;
	    border: 1px solid #D6D6D6;
	    max-height: 200px;
	    overflow-y: auto;">
        <ul id="menuTree" class="ztree" style="margin-top: 0; width: 110px;">
        </ul>
	</div>
</body>
</html>