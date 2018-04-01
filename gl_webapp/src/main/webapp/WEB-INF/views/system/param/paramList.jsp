<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${basePath}/css/table-form.css" rel="stylesheet"/>
<script src="${basePath}/js/system/param/paramList.js"></script>

</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${basePath}/admin/param/list.do">参数列表</a></li>
		<li ><a href="${basePath}/admin/param/edit.do?id=">
				添加参数
		</a></li>
	</ul>

	<div class="row table-form" >
		<form class="form-horizontal" role="form" id="searchForm" action="ajaxList.do">
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">值</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="paramValue" name="value" placeholder="请输入名字">
			    </div>
			    <label for="firstname" class="col-sm-1 control-label">参数类型</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="paramType" name="paramType" placeholder="请输入名字">
			    </div>
			    <div class="col-sm-2">
		      		<button type="button" id="selectByPage" class="btn btn-default">查询</button>
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