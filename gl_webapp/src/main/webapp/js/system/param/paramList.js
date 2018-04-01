

$(function(){
	
	initTable();
	
	$("#selectByPage").click(function(){
		refreshTable();
	});
	
	$("#addBtn").click(function(){
		var url = basePath+"/role/edit.do";
		layer.open({
	      type: 2,
	      title: '新增角色',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['850px' , '540px'],
	      content: url
	    });
	});
	
	$("#deleteBtn").click(function(){
		if($table){
			var selections = $table.bootstrapTable('getSelections');
			var _array = new Array();
			if(selections && selections.length >0){
				for(var i = 0 ; i < selections.length ; i++){
					_array.push(selections[i].id);
				}
				del(_array.join(","));
			}
		}
	});
});

/**
 * 删除参数
 * */
function del(id){
	var url = basePath+"/admin/param/deleteById.do";
	layer.confirm("确认要删除吗?", { title: "系统提示" }, 
		function (index) {  
        	layer.close(index); 
        	$.ajax({
        		url:url,
        		type:"post",
        		data:{
        			id:id
        		},
        		dataType:"json",
        		success:function(data){
        			var index = layer.alert(data.msg);
        			setTimeout(function(){
        				layer.close(index);
        				refreshTable();
        			},1000 ); 
        		}
        	});
    });   
}

/**
 * 编辑角色
 * */
function edit(id){
	var url = basePath+"/admin/param/edit.do?id="+id;
	layer.open({
      type: 2,
      title: '修改角色',
      maxmin: true,
      shadeClose: true, //点击遮罩关闭层
      area : ['850px' , '540px'],
      content: url
    });
}




/**
 * 菜单列表
 * */
var $table = null;
function initTable(){
	$table = $('#dataTable').bootstrapTable({
		url:basePath+'/admin/param/ajaxList.do',
		cache:false,
		method:'post',
		dataType:'json',
		contentType: "application/x-www-form-urlencoded",
		sidePagination:'server',//server 或 client
		striped:true,
		pageNumber:1,
		pagination : true,//开启分页
		search:false,
		queryParams:queryParams,
		queryParamsType:'',
		clickToSelect:true,
		singleSelect:false,
		pageSize : 10,//每页大小
        pageList : [10, 15, 20, 30],//可以选择每页大小
        columns:[
             //{checkbox:true},
             {field:'id',title:'id',sortable:true,width:100,align: 'center',valign: 'middle',visible:false},    
             {field:'value',title:'值',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'title',title:'标签',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'paramType',title:'类型',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'remark',title:'备注',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'events',title:'操作',sortable:false,width:100,align: 'center',valign: 'middle',formatter:function(value,row,index){
            	 return '<div class="table-operation"><a href="#" onclick="edit(\''+row.id+'\')">修改</a> <a href="#" onclick="del(\''+row.id+'\')">删除</a></div>';
             }}
         ]
        
	});
}

/**
 * 刷新列表
 * */
function refreshTable(){
	var solidParams = queryParams();
	$table.bootstrapTable('refreshOptions',solidParams);
}

/**
 * 查询参数
 * */
function queryParams(params){
	var value = $("#paramValue").val();
	var paramType = $("#paramType").val();
	if(!params){
		params={
			pageNumber:1,
			pageSize:10
		};
	}
	var queryParams = {
			value:value,
			paramType:paramType
	};
	return $.extend(queryParams, params);
}
