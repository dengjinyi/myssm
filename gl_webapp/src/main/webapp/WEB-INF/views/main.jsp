<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管廊运维系统</title>
<link rel="stylesheet" type="text/css" href="${basePath}/common/stylesheets/theme.css">
<link rel="stylesheet" href="${basePath}/common/font-awesome/css/font-awesome.css">
<script src="${basePath}/js/main.js"></script>
<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
            var height = $(window).height();
            var h = height - 70;
            $(".content").height(h);
        });
    </script>
<style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        .navbar .nav > li {
		    float: left;
		}
		li {
		    line-height: 20px;
		}
		.navbar-inner {
    		min-height: 60px;
    	}
    </style>
</head>
 <body class=""> 
  <!--<![endif]-->
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Jack Smith
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="brand" href="index.html"><span class="first">Your</span> <span class="second">Company</span></a>
        </div>
    </div>

    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>系统管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="#" src="admin/user/list.do">用户管理</a></li>
            <li ><a href="#" src="admin/menu/list.do">菜单管理</a></li>
            <li ><a href="#" src="admin/role/list.do">角色管理</a></li>
            <li ><a href="#" src="admin/org/list.do">机构管理</a></li>
            <li ><a href="#" src="admin/param/list.do">字典管理</a></li>
        </ul>

    </div>
    

    
    <div class="content">
    	
	    	
	        <!-- <ul class="nav nav-tabs">
			  <li role="presentation" class="active"><a href="#">Home</a></li>
			  <li role="presentation"><a href="#">Profile</a></li>
			  <li role="presentation"><a href="#">Messages</a></li>
			</ul> -->
	        
	       <!--  <ul class="breadcrumb">
	            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
	            <li class="active">Dashboard</li>
	        </ul> -->
		<iframe id="contentMain" src="user/list.do" width="100%" height="100%" style="width:100%;height:100%;border:none;"></iframe>
	       <!-- <div class="container-fluid">
	            
	        </div> --> 
    </div>
  </body>
</html>
