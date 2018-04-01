

$(function(){
	
	initTable();
	
	$("#select").click(function(){
		refreshTable();
	});
	
	$("#addBtn").click(function(){
		var url = basePath+"/menu/edit.do";
		layer.open({
	      type: 2,
	      title: '新增用户',
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
 * 删除菜单
 * */
function del(ids){
	var url = basePath+"/menu/delete.do";
	//判断是否存在子节点。如果有则不给删除。没有则删除
	var flag = checkChildren(ids);
	if(flag){
		alert("存在子菜单,不能删除!");
		return;
	}
	$.ajax({
		url:url,
		type:"post",
		data:{
			ids:ids
		},
		dataType:"json",
		success:function(data){
			alert(data.statuCode);
			$table.bootstrapTable('refresh',{page:1,pageSize:10});
		}
	});
}

function checkChildren(ids){
	var url = basePath+"/menu/checkChildren.do";
	var flag = true;
	$.ajax({
		url:url,
		type:"post",
		data:{
			ids:ids
		},
		dataType:"json",
		async:false,
		success:function(data){
			if(data.msg == "false"){
				flag = false;
			}
		}
	});
	return flag;
}
/**
 * 编辑菜单
 * */
function edit(id){
	var url = basePath+"/menu/edit.do?id="+id;
	layer.open({
      type: 2,
      title: '新增菜单',
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
		url:basePath+'/menu/ajaxList.do',
		cache:false,
		method:'post',
		dataType:'json',
		queryParams:{
			"page":1,
			"pageSize":10
		},
		toolbar:"#toolbar",
		sidePagination:'server',//server 或 client
		striped:true,
		pageNumber:1,
		pagination : true,//开启分页
		search:false,
		queryParams:queryParams,
		clickToSelect:true,
		singleSelect:false,
		pageSize : 10,//每页大小
        pageList : [10, 15, 20, 30],//可以选择每页大小
        columns:[
             {checkbox:true},
             {field:'id',title:'id',sortable:true,width:100,align: 'center',valign: 'middle',visible:false},    
             {field:'name',title:'名称',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'parentId',title:'父级目录',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'url',title:'菜单路径',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'events',title:'操作',sortable:false,width:100,align: 'center',valign: 'middle',formatter:function(value,row,index){
            	 return '<a href="#" onclick="edit(\''+row.id+'\')">修改</a>';
             }}
         ]
        
	});
}

/**
 * 刷新列表
 * */
function refreshTable(){
	var options = $table.bootstrapTable('getOptions');
	var solidParams = queryParams();
	$table.bootstrapTable('refresh',solidParams);
}

/**
 * 查询参数
 * */
function queryParams(params){
	var name = $("#name").val();
	var parentId = $("#parentId").val();
	var queryParams = {
			page:1,
			pageSize:10,
			parentId:parentId
	};
    return queryParams;
}
