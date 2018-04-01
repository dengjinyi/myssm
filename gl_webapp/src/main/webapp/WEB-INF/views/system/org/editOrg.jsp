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
	<script src="${basePath}/js/system/org/editOrg.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${basePath}/org/list.do">机构列表</a></li>
		<li class="active">
			<a href="${basePath}/org/edit.do">
				<c:choose>
					<c:when test="${org.id !=null}">
						修改机构
					</c:when>
					<c:otherwise>
						添加机构
					</c:otherwise>
				</c:choose>
			</a>
		</li>
	</ul>

	<form id="editForm" class="form-horizontal" action="save.do" method="post" novalidate="novalidate" style="margin-top:20px;">
		<input id="id" name="id" type="hidden" value="${org.id}">
		<div class="form-group">
			<label class="col-sm-2 control-label">上级机构:</label>
			<div class="col-sm-10 form-div">
				<div class="input-group">
				  <input id="officeName" name="orgName" type="text" value="" readonly="readonly"
					data-msg-required="" class="form-control-input form-input-w250 required">
					<input type="hidden" name="parentId" id="parentId" value="${org.parentId}"/>
				  <div class="input-group-btn" style="float:left">
				    <a id="orgtreeBtb" href="javascript:" class="btn form-btn"><i class="glyphicon glyphicon-search" aria-hidden="true" onclick="loadOrgTree()"></i></a>
				  </div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">归属区域:</label>
			<div class="col-sm-10 form-div">
				<select id="region" name="region">
					<option value="" selected="selected">请选择</option>
					<option value="1">华为</option>
					<option value="2">京东</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">机构名称:</label>
			<div class="col-sm-10">
				<input id="name" name="name" class="form-control-input required" type="text" value="${org.name}" maxlength="50"><font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">机构编码:</label>
			<div class="col-sm-10">
				<input id="code" name="code" class="form-control-input required" type="text" value="${org.code}" maxlength="50">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">机构类型:</label>
			<div class="col-sm-10">
				<select id="orgType" name="orgType">
					<option value="" selected="selected">请选择</option>
					<option value="1">华为</option>
					<option value="2">京东</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">机构级别:</label>
			<div class="col-sm-10">
				<select id="orgLevel" name="orgLevel">
					<option value="" selected="selected">请选择</option>
					<option value="1">华为</option>
					<option value="2">京东</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">主负责人:</label>
			<div class="col-sm-10">
				<input id="fistLeading" class="form-control-input" name="fistLeading" type="text" value="${org.fistLeading}" 
					maxlength="50" minlength="3" equalto="#password">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">副负责人:</label>
			<div class="col-sm-10">
				<input id="secondLeading" name="secondLeading" class="form-control-input" type="text" value="${user.secondLeading}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系地址:</label>
			<div class="col-sm-10">
				<input id="address" name="address" type="text" class="form-control-input" value="${org.address}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮政编号:</label>
			<div class="col-sm-10">
				<input id="postCode" name="postCode" type="text" class="form-control-input" value="${org.postCode}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">负责人:</label>
			<div class="col-sm-10">
				<input id="leader" name="leader" type="text" class="form-control-input" value="${org.leader}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">电话:</label>
			<div class="col-sm-10">
				<input id="tel" name="tel" type="text" class="form-control-input" value="${org.tel}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">传真:</label>
			<div class="col-sm-10">
				<input id="fax" name="fax" type="text" class="form-control-input" value="${org.fax}" maxlength="100">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮箱:</label>
			<div class="col-sm-10">
				<input id="email" name="email" type="text" class="form-control-input email" value="${org.email}" maxlength="100">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">备注:</label>
			<div class="col-sm-6">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge form-control form-input-w250" rows="3">${org.remark }</textarea>
			</div>
		</div>
		
		<div class="row" style="margin-top:40px;">
			<div class="col-sm-6" style="text-align:center;">
				<button type="button" class="btn btn-primary" id="saveUserBtn">
					保存
				</button>
				<button type="button" id="goBack" class="btn btn-default" data-dismiss="modal">返回
				</button>
			</div>
			
			
		</div>
	</form>
	
	
</body>
</html>