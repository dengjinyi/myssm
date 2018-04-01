<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增用户</title>
	<link href="${basePath}/css/table-form.css" rel="stylesheet"/>
	<script type="text/javascript" src="${basePath}/common/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="${basePath}/common/jquery-validation/jquery.validate.js"></script>
	<script type="text/javascript" src="${basePath}/common/jquery-validation/jquery.metadata.js"></script>
	<script type="text/javascript" src="${basePath}/common/jquery-validation/messages_cn.js"></script>
	<script src="${basePath}/js/system/param/editParam.js"></script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li ><a href="${basePath}/admin/param/list.do">参数列表</a></li>
		<li class="active"><a href="${basePath}/admin/param/edit.do">
			<c:choose>
				<c:when test="${param.id !=null}">
					修改参数
				</c:when>
				<c:otherwise>
					添加参数
				</c:otherwise>
			</c:choose>
		</a></li>
	</ul>
	<form id="editForm" class="form-horizontal" action="save.do" method="post" novalidate="novalidate" style="margin-top:20px;">
		<input id="id" name="id" type="hidden" value="${param.id}">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">值:</label>
			<div class="col-sm-10">
				<input id="value" name="value" class="form-control-input required"  type="text" value="${param.name}" maxlength="50">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">标签:</label>
			<div class="col-sm-10">
				<input id="title" name="title" class="form-control-input required"  type="text" value="${param.title}" maxlength="50">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">类型:</label>
			<div class="col-sm-10">
				<input id="paramType" name="paramType" class="form-control-input required" type="text" value="${param.paramType}" maxlength="50">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">排序:</label>
			<div class="col-sm-10">
				<input id="orderBy" name="orderBy" type="text" value="${param.orderBy}" maxlength="11" 
					class="form-control-input">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">备注:</label>
			<div class="col-sm-6">
				<textarea id="remark" name="remark" maxlength="200" class="input-xlarge form-control form-input-w250" rows="3">${param.remark}</textarea>
			</div>
		</div>
		
		<div class="row" style="margin-top:40px;">
			<div class="col-sm-6" style="text-align:center;">
				<button type="submit" class="btn btn-primary" >
					保存
				</button>
				<button type="button" id="backHome" class="btn btn-default" >返回
				</button>
			</div>
		</div>
	</form>
	
	
</body>
</html>