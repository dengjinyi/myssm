<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="${basePath}/css/main.css" rel="stylesheet"/>
	<script src="${basePath}/js/main.js"></script>
</head>


<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-center header-center">
            <li><a href="#">首页</a></li>
            <li><a href="#">系统管理</a></li>
            <li><a href="#">数据模型管理</a></li>
            <li><a href="#">战法管理</a></li>
            <li><a href="#">资源管理</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid container-main" id="containerMain">
        <div class="container-left">
	          <ul class="nav nav-sidebar">
	            <li><a href="#" src="user/list.do">用户管理</a></li>
	            <li><a href="#" src="menu/list.do">菜单管理</a></li>
	            <li><a href="#" src="role/list.do">角色管理</a></li>
	            <li><a href="#" src="org/list.do">机构管理</a></li>
	          </ul>
        </div>
        <div class="container-center">
          	<iframe id="content" src="" style="width:100%;height:100%;border:none;"></iframe>
        </div>
   </div>
</body>
</html>
