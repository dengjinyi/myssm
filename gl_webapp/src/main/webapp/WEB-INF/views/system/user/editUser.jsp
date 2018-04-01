<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link href="${basePath}/css/table-form.css" rel="stylesheet"/>
<link href="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet"/>
<link href="${basePath}/common/font-awesome/css/font-awesome.css" rel="stylesheet"/>

<script src="${basePath}/common/bootstrap-treeview/bootstrap-treeview.min.js"></script>
<link rel="stylesheet" href="${basePath}/common/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="${basePath}/common/zTree/js/jquery.ztree.all.js"></script>
<script src="${basePath}/common/layer/layer.js"></script>
<script src="${basePath}/js/system/user/editUser.js"></script>
	<style>
		font{
			padding-left:5px;
		}
	</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${basePath}/user/list.do">用户列表</a></li>
		<li class="active"><a href="${basePath}/user/edit.do">
			<c:choose>
				<c:when test="${user.id !=null}">
					修改添加
				</c:when>
				<c:otherwise>
					添加用户
				</c:otherwise>
			</c:choose>
		</a></li>
	</ul>
	<div>
	<form id="editUserForm" class="form-horizontal" action="saveUser.do" method="post" novalidate="novalidate" style="margin-top:20px;">
		<input id="id" name="id" type="hidden" value="${user.id}">
		<div class="form-group">
			<label class="col-sm-2 control-label">归属公司:</label>
			<div class="col-sm-10 form-div">
				<select id=company name="company">
					<option value="" selected="selected">请选择</option>
					<option value="1">华为</option>
					<option value="2">京东</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 form-div control-label">归属部门:</label>
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
			<label class="col-sm-2 control-label">工号:</label>
			<div class="col-sm-10">
				<input id="jobNo" name="jobNo" class="form-control-input required" type="text" value="${user.jobNo}" maxlength="50"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名:</label>
			<div class="col-sm-10">
				<input id="name" name="name" class="form-control-input required" type="text" value="${user.name}" maxlength="50"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">登录名:</label>
			<div class="col-sm-10">
				<input id="account" name="account" class="form-control-input required" type="text" value="${user.account}" maxlength="50"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">密码:</label>
			<div class="col-sm-10">
				<input id="password" name="password" type="password" value="${user.password}" maxlength="50" minlength="3" 
					class="form-control-input required"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">确认密码:</label>
			<div class="col-sm-10">
				<input id="repassword" class="form-control-input" name="repassword" type="password" value="${user.password}" 
					maxlength="50" minlength="3" equalto="#password"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮箱:</label>
			<div class="col-sm-10">
				<input id="email" name="email" class="form-control-input" class="email" type="text" value="${user.email}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">电话:</label>
			<div class="col-sm-10">
				<input id="phone" name="phone" type="text" class="form-control-input" value="${user.phone}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">手机:</label>
			<div class="col-sm-10">
				<input id="mobile" name="mobile" type="text" class="form-control-input" value="${user.mobile}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">是否允许登录:</label>
			<div class="col-sm-10">
				<select id="status" name="status" class="form-control-input">
					<option value="1" selected="selected">是</option>
					<option value="0">否</option>
				</select>
				<font color="red">*</font> “是”代表此账号允许登录，“否”则表示此账号不允许登录
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">用户类型:</label>
			<div class="col-sm-10">
				<select id="userType" name="userType">
					<option value="" selected="selected">请选择</option>
					<option value="1">系统管理</option>
					<option value="2" selected="selected">部门经理</option>
					<option value="3">普通用户</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">用户角色:</label>
			<div class="col-sm-10">
				<span><input id="roleIdList1" name="roleIdList" class="required" type="checkbox" 
					value=""><label for="roleIdList1">普通用户</label></span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">备注:</label>
			<div class="col-sm-6">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge form-control form-input-w250" rows="3">${user.remark }</textarea>
			</div>
			<!-- <label class="col-sm-2 control-label">头像:</label>
			<div class="col-sm-10">
				<input id="nameImage" name="photo" maxlength="255" class="input-xlarge" type="hidden" value="">
					<ol id="nameImagePreview">
					<li style="list-style:none;padding-top:5px;">无</li>
				</ol>
				<a href="javascript:" onclick="nameImageFinderOpen();" class="btn">选择</a>&nbsp;
				<a href="javascript:" onclick="nameImageDelAll();" class="btn">清除</a>
			</div> -->
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
	</div>
	
	<div id="treeContent" style="display: none; position: absolute;width: 100%;
	    background: #fff;
	    border: none;
	    overflow-y: auto;margin-top:10px;">
	    	<form class="form-horizontal">
		    	<div class="form-group">
					<label class="col-sm-3 control-label">关键词:</label>
					<div class="col-sm-8">
						<div class="input-group">
						  <input type="text" class="form-control">
						  <span class="input-group-addon input-group-sm" id="basic-addon2">
						  	搜索
						  </span>
						</div>
					</div>
				</div>
			</form>
			<div class="form-group">
				<div class="col-sm-12">
					<ul id="orgTree" class="ztree" style="margin-top: 0; width: 110px;">
		        	</ul>
				</div>
	        </div>
	</div>
</body>
</html>