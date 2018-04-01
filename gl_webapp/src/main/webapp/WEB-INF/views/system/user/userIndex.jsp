<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script>
	
	</script>
	<style>
		.chosen-container-single .chosen-single {
		    position: relative;
		    display: block;
		    overflow: hidden;
		    padding: 0 0 0 8px;
		    height: 34px;
		    border: 1px solid #aaa;
		    border-radius: 5px;
		    background-color: #fff;
		    background: linear-gradient(#fff 20%,#f6f6f6 50%,#eee 52%,#f4f4f4 100%);
		    background-clip: padding-box;
		    box-shadow: 0 0 3px #fff inset, 0 1px 1px rgba(0,0,0,.1);
		    color: #444;
		    text-decoration: none;
		    white-space: nowrap;
		    line-height: 33px;
		}
	</style>
</head>
<body>
	<div class="row" style="background:#f0f0f0;padding:10px 0px;margin-bottom:10px;">
		<form class="form-horizontal" role="form">
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">用户名</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="firstname" placeholder="请输入名字">
			    </div>
		    	<label for="firstname" class="col-sm-1 control-label">账号</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="firstname" placeholder="请输入名字">
			    </div>
		  	</div>
		  	<div class="form-group">
		    	<label for="firstname" class="col-sm-1 control-label">用户名</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="firstname" placeholder="请输入名字">
			    </div>
		    	<label for="firstname" class="col-sm-1 control-label">账号</label>
			    <div class="col-sm-2">
			     	<select class="my_select_box form-control" data-placeholder="Select Your Options">
					  <option value="1">Option 1</option>
					  <option value="2" selected>Option 2</option>
					  <option value="3">Option 3</option>
					</select>
			    </div>
			    <div class="col-sm-2">
			      <button type="button" class="btn btn-default" id="select">查询</button>
			    </div>
		  	</div>
		</form>
	</div>

	<table id="dataTable">
		
	</table>
	
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:350px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				<div>模态框（Modal）标题</div>
				<div>模态框（Modal）标题</div>
				<div>模态框（Modal）标题</div>
				<div>模态框（Modal）标题</div>
				<div>模态框（Modal）标题</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</body>
</html>